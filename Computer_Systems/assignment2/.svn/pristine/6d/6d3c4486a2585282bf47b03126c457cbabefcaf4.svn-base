// name: Zikang, Wu
// student id: a1816094


// convert Hack Machine Code into Assembly Language
#include "iobuffer.h"
#include "symbols.h"
#include "tokeniser-d.h"
#include <vector>
#include <iostream>
#include <math.h>
#include <algorithm>

// to make out programs a bit neater
using namespace std ;

using namespace CS_IO_Buffers ;
using namespace CS_Symbol_Tables ;
using namespace Hack_Disassembler ;

// This program must disassemble Hack Machine Code and output the equivalent Hack Assembly Language.
//
// A-instructions must be translated into symbolic form using the following rules:
//
// 1. IF symbols is false
//    THEN
//     - the A-instruction is output in numeric form.
//
// 2. IF an A-instruction is followed by a C-instruction and the jump bits of the C-instruction are not "000"
//    THEN
//     - IF the value of the A-instruction is the address an instruction in the program
//       THEN
//        - the instruction must be allocated a label and the A-instruction must use this label
//        - the first labelled location in memory must be labelled L0, the next L1 and so on
//
// 3. IF an A-instruction is followed by a C-instruction that reads or writes memory
//    THEN
//     - IF the address has a predefined name
//       THEN
//        - the A-instruction must use the predefined name
//        - where there is a choice, use SP, LCL, ARG, THIS and THAT in preference to R0, R1, R2 R3 and R4
//    - IF the address is the address of an existing variable location
//      THEN
//       - the A-instructon must use the variable's name
//    - IF the address is the address of the next free variable location
//      THEN
//       - the A-instructon must use the next free variable's name and
//       - the address of the next free variable must be incremented by 1
//       - the first variable name allocated will be for address 16 and will be called v_0
//       - the second variable name allocated will be for address 17 and will be called v_1
//       - and so on
//
// 4. ELSE the A-instruction is output in numeric form.
//
// C-instructions must be translated using the following rules:
//
// 1. IF the destination bits are "000"
//    THEN
//     - do not output a destination component for the C-instruction
//
// 2. IF the ALU operation is not recognised
//   THEN
//    - replace the ALU operation with: "< ** UNDEFINED ALU OPERATION ** >"
//
// Do not output a jump component for a C-instruction if it the jump bits are "000"
// 3. IF the jump bits are "000"
//    THEN
//     - do not output a jump componentfor the C-instruction
//

// declare four tables
symbols symbolTable;
symbols destTable;
symbols aluTable;
symbols jmpTable;
symbols labelTable;

// this function initialize a symbol table
symbols initializeSymbolTable(symbols symbolTable)
{
    // create a symbol table
    symbolTable = symbols_create();

    // insert VM control pointers
    symbols_insert(symbolTable, "0", "SP");
    symbols_insert(symbolTable, "1", "LCL");
    symbols_insert(symbolTable, "2", "ARG");
    symbols_insert(symbolTable, "3", "THIS");
    symbols_insert(symbolTable, "4", "THAT");

    // insert predefined symbols R5 to R15
    symbols_insert(symbolTable, "5", "R5");
    symbols_insert(symbolTable, "6", "R6");
    symbols_insert(symbolTable, "7", "R7");
    symbols_insert(symbolTable, "8", "R8");
    symbols_insert(symbolTable, "9", "R9");
    symbols_insert(symbolTable, "10", "R10");
    symbols_insert(symbolTable, "11", "R11");
    symbols_insert(symbolTable, "12", "R12");
    symbols_insert(symbolTable, "13", "R13");
    symbols_insert(symbolTable, "14", "R14");
    symbols_insert(symbolTable, "15", "R15");

    // insert IO pointers
    symbols_insert(symbolTable, "16384", "SCREEN");
    symbols_insert(symbolTable, "24576", "KBD");

    return symbolTable;
}

// initialize a dest table
symbols initializeDestTable(symbols destTable)
{
    destTable = symbols_create();

    // insert all destination bits in c-instruction
    symbols_insert(destTable, "100", "A");
    symbols_insert(destTable, "001", "M");
    symbols_insert(destTable, "010", "D");
    symbols_insert(destTable, "101", "AM");
    symbols_insert(destTable, "110", "AD");
    symbols_insert(destTable, "011", "MD");
    symbols_insert(destTable, "111", "AMD");

    return destTable;
}

// initializa an alu table
symbols initializeAluTable(symbols aluTable)
{
    aluTable = symbols_create();

    // insert all alu bits in c-instruction
    symbols_insert(aluTable, "0101010", "0");
    symbols_insert(aluTable, "0111111", "1");
    symbols_insert(aluTable, "0111010", "-1");
    symbols_insert(aluTable, "0001100", "D");
    symbols_insert(aluTable, "0110000", "A");
    symbols_insert(aluTable, "0001101", "!D");
    symbols_insert(aluTable, "0110001", "!A");
    symbols_insert(aluTable, "0001111", "-D");
    symbols_insert(aluTable, "0110011", "-A");
    symbols_insert(aluTable, "0011111", "D+1");
    symbols_insert(aluTable, "0110111", "A+1");
    symbols_insert(aluTable, "0001110", "D-1");
    symbols_insert(aluTable, "0110010", "A-1");
    symbols_insert(aluTable, "0000010", "D+A");
    symbols_insert(aluTable, "0010011", "D-A");
    symbols_insert(aluTable, "0000111", "A-D");
    symbols_insert(aluTable, "0000000", "D&A");
    symbols_insert(aluTable, "1110000", "M");
    symbols_insert(aluTable, "1110001", "!M");
    symbols_insert(aluTable, "1110011", "-M");
    symbols_insert(aluTable, "1110111", "M+1");
    symbols_insert(aluTable, "1110010", "M-1");
    symbols_insert(aluTable, "1000010", "D+M");
    symbols_insert(aluTable, "1010011", "D-M");
    symbols_insert(aluTable, "1000111", "M-D");
    symbols_insert(aluTable, "1000000", "D&M");
    symbols_insert(aluTable, "1010101", "D|M");

    return aluTable;
}

// initialize a jmp table
symbols initializeJmpTable(symbols jmpTable)
{
    jmpTable = symbols_create();
    
    // insert all jump bits in c-instruction
    symbols_insert(jmpTable, "001", "JGT");
    symbols_insert(jmpTable, "010", "JEQ");
    symbols_insert(jmpTable, "011", "JGE");
    symbols_insert(jmpTable, "100", "JLT");
    symbols_insert(jmpTable, "101", "JNE");
    symbols_insert(jmpTable, "110", "JLE");
    symbols_insert(jmpTable, "111", "JMP");

    return jmpTable;
}

// initialize a label table
symbols initializeLabelTable(symbols labelTable)
{
    labelTable = symbols_create();
    return labelTable;
}

// Hack Machine Code:
// program  ::= (instr tk_eol?)* tk_eoi
// instr    ::= tk_a_instr | tk_c_instr

// parse Hack Machine Code and return a vector of tokens, one per instruction
vector<Token> parse_program()
{
    vector<Token> instructions ;

    while ( have(tk_instruction) )
    {
        instructions.push_back(mustbe(tk_instruction)) ;
        if ( have(tk_eol) ) next_token() ;
    }
    mustbe(tk_eoi) ;

    return instructions ;
}

/*****************   REPLACE THE FOLLOWING CODE  ******************/
// transfer from binary to decimal
int toDecimal(string bin)
{ 
    int decimal = 0;
    int count = 0;

    // get every bit of the binary
    for ( int i = bin.length() - 1; i >= 0; i-- )
    {
        int tmp = bin[i] - '0';

        if ( tmp == 1)
            decimal += pow(2, count);

        count++;
    }

    return decimal;
}

// walk through the program first to find labels
static void search_labels(vector<Token> instructions)
{
    // calculate label number
    int label_counter = 0;

    // save the location of labels
    vector<int> labelLocation;

    // read the instructions
    for ( int i = 0; i < instructions.size(); i++ )
    {
        string spelling = token_spelling(instructions[i]);
        // if it's a-instruction
        if ( spelling[0] == '0' )
        {
            // next is a c instruction and if there is a jump
            if ( token_jump(instructions[i+1]) != "000" )
            {
                int value = toDecimal(spelling);
                labelLocation.push_back(value);
            }                       
        }
    }

    // remove the repeating value
    for ( int i = 1; i < labelLocation.size(); i++ )
    {
        for ( int j = i - 1; j >= 0; j-- )
        {
            if ( labelLocation[j] == labelLocation[i] )
                labelLocation.erase(labelLocation.begin() + i);
        }
    }

    // sort the label location
    sort(labelLocation.begin(), labelLocation.end());

    for ( int i = 0; i < labelLocation.size(); i++ )
    {
        string label_name = "L";
        label_name.append(to_string(label_counter));
        symbols_insert(labelTable, to_string(labelLocation[i]), label_name); 
        label_counter++;
    }                
}


// disassemble a Hack Machine Code program without using any symbols
static void disassemble_no_symbols(vector<Token> instructions)
{
    // read the instructions
    for ( int i = 0; i < instructions.size(); i++ )
    {
        string spelling = token_spelling(instructions[i]);
        // if it's a-instruction
        if ( spelling[0] == '0' )
        {
            int value = toDecimal(spelling);
            write_to_output("        ");
            write_to_output("@");
            write_to_output(to_string(value));
            write_to_output("\n");
        }

        // if it's c-instruction
        if ( spelling[0] == '1' )
        {
            // destination bits
            string dest = symbols_lookup(destTable, token_dest(instructions[i]));
            if ( dest != "" )
                dest.append("="); 

            // alu bits
            string sevenBits = token_a_bit(instructions[i]);
            sevenBits.append(token_alu_op(instructions[i]));
            string alu = symbols_lookup(aluTable, sevenBits);
            string jump = symbols_lookup(jmpTable, token_jump(instructions[i]));
            if ( jump != "" )
                alu.append(";");

            string c = dest;
            c.append(alu);
            c.append(jump);
            write_to_output("        ");
            write_to_output(c);
            write_to_output("\n");
        }
    }
}

// convert Hack Machine Code into Assembly Language
// use predefined names, generic label names and generic variable names
static void disassemble_symbols(vector<Token> instructions)
{
    // search labels first
    search_labels(instructions);

    // cout the variable
    int variable_counter = 0;

    // read the instructions
    for ( int i = 0; i < instructions.size(); i++ )
    {
        string spelling = token_spelling(instructions[i]);

        // if line = label location
        string label_name = symbols_lookup(labelTable, to_string(i));
        if ( label_name != "" )
        {
            write_to_output("(");
            write_to_output(label_name);
            write_to_output(")\n");
        }

        // if it's a-instruction
        if ( spelling[0] == '0' )
        {
            // next is a c instruction and if it reads or writes Memory
            if ( token_dest(instructions[i+1])[2] == '1' || token_a_bit(instructions[i+1]) == "1" )
            {
                int value = toDecimal(spelling);
                string variable_name = symbols_lookup(symbolTable, to_string(value));
                // if not found
                if ( variable_name == "" )
                {
                    string variable = "v_";
                    variable.append(to_string(variable_counter));
                    symbols_insert(symbolTable, to_string(value), variable);
                    write_to_output("        ");
                    write_to_output("@");
                    write_to_output(variable);
                    write_to_output("\n");
                    variable_counter++;
                }
                // if found
                else
                {
                    write_to_output("        ");
                    write_to_output("@");
                    write_to_output(variable_name);
                    write_to_output("\n");
                }
            }

            // if it does not read memory, than it's the same as no name
            else
            {
                int value = toDecimal(spelling);
                string name = symbols_lookup(labelTable, to_string(value));

                if (name != "" )
                {
                    write_to_output("        ");
                    write_to_output("@");
                    write_to_output(name);
                    write_to_output("\n");
                }

                else
                {
                    write_to_output("        ");
                    write_to_output("@");
                    write_to_output(to_string(value));
                    write_to_output("\n");
                }
            }      
        }

        // if it's c-instruction
        if ( spelling[0] == '1' )
        {
            // destination bits
            string dest = symbols_lookup(destTable, token_dest(instructions[i]));
            if ( dest != "" )
                dest.append("="); 

            // alu bits
            string sevenBits = token_a_bit(instructions[i]);
            sevenBits.append(token_alu_op(instructions[i]));
            string alu = symbols_lookup(aluTable, sevenBits);
            string jump = symbols_lookup(jmpTable, token_jump(instructions[i]));
            if ( jump != "" )
                alu.append(";");

            string c = dest;
            c.append(alu);
            c.append(jump);
            write_to_output("        ");
            write_to_output(c);
            write_to_output("\n");
        }
    }
}

/*****************        DOWN TO HERE         ******************/


// main program
int main(int argc,char **argv)
{
    // initialise tokeniser
    next_token() ;

    // initialise tables
    symbolTable = initializeSymbolTable(symbolTable);
    destTable = initializeDestTable(destTable);
    aluTable = initializeAluTable(aluTable);
    jmpTable = initializeJmpTable(jmpTable);
    labelTable = initializeLabelTable(labelTable);

    // is the first command line argument "N", ie Numeric Output ?
    if ( argc > 1 && string(argv[1]) == "N" )
    {
        // YES, output all A-instructions in numeric form
        disassemble_no_symbols(parse_program()) ;
    }
    else
    {
        // NO, output A-instructions in symbolic form where possible
        disassemble_symbols(parse_program()) ;
    }

    // flush the output and any errors
    print_output() ;
    print_errors() ;
}

