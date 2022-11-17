// name: Zikang, Wu
// student id: a1816094


// convert an abstract syntax tree for Hack Assembly language into machine code
#include "iobuffer.h"
#include "symbols.h"
#include "tokeniser.h"
#include "abstract-syntax-tree.h"

// to simplify the code
using namespace std ;
using namespace CS_IO_Buffers ;
using namespace CS_Symbol_Tables ;
using namespace Hack_Assembler ;

// declare four tables
isymbols symbolTable;
symbols destTable;
symbols aluTable;
symbols jmpTable;

// initialize variable location
int vLocation = 16;


// this function initialize a symbol table
isymbols initializeSymbolTable(isymbols symbolTable)
{
    // create a symbol table
    symbolTable = isymbols_create();

    // insert VM control pointers
    isymbols_insert(symbolTable, "SP", 0);
    isymbols_insert(symbolTable, "LCL", 1);
    isymbols_insert(symbolTable, "ARG", 2);
    isymbols_insert(symbolTable, "THIS", 3);
    isymbols_insert(symbolTable, "THAT", 4);

    // insert predefined symbols R0 to R15
    isymbols_insert(symbolTable, "R0", 0);
    isymbols_insert(symbolTable, "R1", 1);
    isymbols_insert(symbolTable, "R2", 2);
    isymbols_insert(symbolTable, "R3", 3);
    isymbols_insert(symbolTable, "R4", 4);
    isymbols_insert(symbolTable, "R5", 5);
    isymbols_insert(symbolTable, "R6", 6);
    isymbols_insert(symbolTable, "R7", 7);
    isymbols_insert(symbolTable, "R8", 8);
    isymbols_insert(symbolTable, "R9", 9);
    isymbols_insert(symbolTable, "R10", 10);
    isymbols_insert(symbolTable, "R11", 11);
    isymbols_insert(symbolTable, "R12", 12);
    isymbols_insert(symbolTable, "R13", 13);
    isymbols_insert(symbolTable, "R14", 14);
    isymbols_insert(symbolTable, "R15", 15);

    // insert IO pointers
    isymbols_insert(symbolTable, "SCREEN", 16384);
    isymbols_insert(symbolTable, "KBD", 24576);

    return symbolTable;
}

// initialize a dest table
symbols initializeDestTable(symbols destTable)
{
    destTable = symbols_create();

    // insert all destination bits in c-instruction
    symbols_insert(destTable, "A", "100");
    symbols_insert(destTable, "M", "001");
    symbols_insert(destTable, "D", "010");
    symbols_insert(destTable, "AM", "101");
    symbols_insert(destTable, "AD", "110");
    symbols_insert(destTable, "MD", "011");
    symbols_insert(destTable, "AMD", "111");

    return destTable;
}

// initializa an alu table
symbols initializeAluTable(symbols aluTable)
{
    aluTable = symbols_create();

    // insert all alu bits in c-instruction
    symbols_insert(aluTable, "0", "0101010");
    symbols_insert(aluTable, "1", "0111111");
    symbols_insert(aluTable, "-1", "0111010");
    symbols_insert(aluTable, "D", "0001100");
    symbols_insert(aluTable, "A", "0110000");
    symbols_insert(aluTable, "!D", "0001101");
    symbols_insert(aluTable, "!A", "0110001");
    symbols_insert(aluTable, "-D", "0001111");
    symbols_insert(aluTable, "-A", "0110011");
    symbols_insert(aluTable, "D+1", "0011111");
    symbols_insert(aluTable, "A+1", "0110111");
    symbols_insert(aluTable, "D-1", "0001110");
    symbols_insert(aluTable, "A-1", "0110010");
    symbols_insert(aluTable, "D+A", "0000010");
    symbols_insert(aluTable, "D-A", "0010011");
    symbols_insert(aluTable, "A-D", "0000111");
    symbols_insert(aluTable, "D&A", "0000000");
    symbols_insert(aluTable, "M", "1110000");
    symbols_insert(aluTable, "!M", "1110001");
    symbols_insert(aluTable, "-M", "1110011");
    symbols_insert(aluTable, "M+1", "1110111");
    symbols_insert(aluTable, "M-1", "1110010");
    symbols_insert(aluTable, "D+M", "1000010");
    symbols_insert(aluTable, "D-M", "1010011");
    symbols_insert(aluTable, "M-D", "1000111");
    symbols_insert(aluTable, "D&M", "1000000");
    symbols_insert(aluTable, "D|M", "1010101");

    return aluTable;
}

// initialize a jmp table
symbols initializeJmpTable(symbols jmpTable)
{
    jmpTable = symbols_create();
    
    // insert all jump bits in c-instruction
    symbols_insert(jmpTable, "JGT", "001");
    symbols_insert(jmpTable, "JEQ", "010");
    symbols_insert(jmpTable, "JGE", "011");
    symbols_insert(jmpTable, "JLT", "100");
    symbols_insert(jmpTable, "JNE", "101");
    symbols_insert(jmpTable, "JLE", "110");
    symbols_insert(jmpTable, "JMP", "111");

    return jmpTable;
}

// this function transfer a decimal number into binary
string toBinary(int num)
{
    string binary = "";
    int count = 0;

    while ( num != 0 )
    {
        int bin = num%2;

        if ( bin == 0 )
            binary += '0';

        if ( bin == 1 )
            binary += '1';

        num /= 2;

        count++;
    }

    while ( count != 16 )
    {
        binary += '0';
        count++;
    }

    string result = "";

    // convert the bits
    for ( int i = binary.length() - 1; i >= 0; i-- )
        result += binary[i];
    
    return result;
}

// this function provides an example of how to walk an abstract syntax tree constructed by ast_parse_xml()
// it visits each instruction or label in order and accesses all fields in each tree node
void walk_program1(ast the_program)
{
    // this stores the instruction line
    int location_counter = 0;

    // the_program contains a vector of instructions
    int ninstructions = size_of_program(the_program) ;

    for ( int i = 0 ; i < ninstructions ; i++ )
    {
        ast instruction = get_program(the_program,i) ;

        string temp ;
        switch(ast_node_kind(instruction))
        {
        case ast_label:
            temp = get_label_name(instruction) ;
            isymbols_insert(symbolTable, temp, location_counter);
            break ;
        case ast_a_name:
            location_counter++;
            break ;
        case ast_a_instruction:
            location_counter++;
            break ;
        case ast_c_instruction:
            location_counter++;
            break ;
        default:
            fatal_error(0,"// bad node - expected ast_label,ast_a_name,ast_a_instruction or ast_c_instruction\n") ;
            break ;
        }
    }
}

void walk_program2(ast the_program)
{
    // the_program contains a vector of instructions
    int ninstructions = size_of_program(the_program) ;

    for ( int i = 0 ; i < ninstructions ; i++ )
    {
        ast instruction = get_program(the_program,i) ;

        string temp ;

        switch(ast_node_kind(instruction))
        {
        case ast_label:
            break ;
        case ast_a_name:
        {
            temp = get_a_name_unresolved(instruction) ;

            // look into the symbol table
            int value = isymbols_lookup(symbolTable, temp);

            // if it's a new variable
            if ( value == -1 )
            {
                isymbols_insert(symbolTable, temp, vLocation);
                write_to_output(toBinary(vLocation));
                write_to_output("\n");
                vLocation++;
            }

            // if it's already in the symbol table
            else
            {
                write_to_output(toBinary(value));
                write_to_output("\n");
            }
            
            break ;
        }
        case ast_a_instruction:
        {
            int aValue = get_a_instruction_value(instruction) ;
            write_to_output(toBinary(aValue));
            write_to_output("\n");
            break ;
        }
        case ast_c_instruction:
        {
            temp = get_c_instruction_dest(instruction) ;
            string dest = symbols_lookup(destTable, temp);

            // if not found, then no destination
            if ( dest == "" )
                dest = "000";

            temp = get_c_instruction_alu(instruction) ;
            string alu = symbols_lookup(aluTable, temp);
            temp = get_c_instruction_jump(instruction) ;
            string jump = symbols_lookup(jmpTable, temp);

            // if not found, then no jump
            if ( jump == "" )
                jump = "000";

            // get the whole c-instruction
            string cInstruction = "111";
            cInstruction.append(alu);
            cInstruction.append(dest);
            cInstruction.append(jump);
            
            // write out
            write_to_output(cInstruction);
            write_to_output("\n");
            break ;
        }
        default:
            fatal_error(0,"// bad node - expected ast_label,ast_a_name,ast_a_instruction or ast_c_instruction\n") ;
            break ;
        }
    }
}

// translate an abstract syntax tree representation of Hack Assembly language into Hack machine code
static void asm_translator(ast the_program)
{
    symbolTable = initializeSymbolTable(symbolTable);
    destTable = initializeDestTable(destTable);
    aluTable = initializeAluTable(aluTable);
    jmpTable = initializeJmpTable(jmpTable);

    walk_program1(the_program);
    walk_program2(the_program);
}

// main program
int main(int argc,char **argv)
{
    // error messages
    config_errors(iob_buffer) ;

    // parse abstract syntax tree and pass to the translator
    asm_translator(ast_parse_xml()) ;

    // flush output and errors
    print_output() ;
    print_errors() ;
}
