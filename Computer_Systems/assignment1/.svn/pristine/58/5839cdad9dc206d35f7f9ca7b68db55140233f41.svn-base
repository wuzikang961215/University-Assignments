// Author name: Zikang, Wu
// Sudent ID: a1816094

// tokeniser implementation for the workshop example language

#include "tokeniser-extras.h"

// to shorten the code
using namespace std ;

// we are extending the Assignment_Tokeniser namespace
namespace Assignment_Tokeniser
{
    // * wspace ::= '\t' | '\n' | '\r' | ' '
    static void parse_wspace()
    {

        // if combined with mustbe

        if ( next_char_isa('\t') )   
            next_char_mustbe('\t');

        else if ( next_char_isa('\n') )
            next_char_mustbe('\n');

        else if ( next_char_isa('\r') )
            next_char_mustbe('\r');

        else if ( next_char_isa(' ') )
            next_char_mustbe(' ');

        else
            did_not_find_char(cg_wspace);
    }

    // * identifier  ::= ('a'-'z'|'A'-'Z'|'^') id_letter* '?'?
    static void parse_identifier()
    {
        read_next_char();

        while ( next_char_isa(cg_id_letter) )
            next_char_mustbe(cg_id_letter);

        if ( next_char_isa('?') ) 
            next_char_mustbe('?');
    }

    // bin_fraction ::= '.' bin_digit*
    static void parse_bin_fraction()
    {
        next_char_mustbe('.');

        while ( next_char_isa(cg_bin_digit) )
            next_char_mustbe(cg_bin_digit); 
    }

    // oct_fraction ::= '.' oct_digit*
    static void parse_oct_fraction()
    {
        next_char_mustbe('.');

        while ( next_char_isa(cg_oct_digit) )
            next_char_mustbe(cg_oct_digit);
    }

    // decimal19    ::= ('1'-'9') dec_digit*

    // dec_fraction ::= '.' dec_digit*
    static void parse_dec_fraction()
    {
        next_char_mustbe('.');

        while ( next_char_isa(cg_dec_digit) )
            next_char_mustbe(cg_dec_digit);
    }


    // hex_fraction ::= '.' hex_digit*
    static void parse_hex_fraction()
    {
        next_char_mustbe('.');

        while ( next_char_isa(cg_hex_digit) )
            next_char_mustbe(cg_hex_digit);
    }


    //  number ::= binary | octal | decimal | hexadecimal
    static void parse_number()
    {

       // '0' can start 4 rules, binary, octal, decimal and hexadecimal

        if ( next_char_isa('0') )  
        {
            read_next_char();

            if ( next_char_isa('b') )
            {
                next_char_mustbe('b');
                next_char_mustbe(cg_bin_digit);

                while ( next_char_isa(cg_bin_digit) )
                    next_char_mustbe(cg_bin_digit);

                if ( next_char_isa('.') )
                    parse_bin_fraction();
            }

            else if ( next_char_isa(cg_oct_digit) )
            {
                next_char_mustbe(cg_oct_digit);

                while ( next_char_isa(cg_oct_digit) )
                    next_char_mustbe(cg_oct_digit);

                if ( next_char_isa('.') )
                    parse_oct_fraction();
            }

            else if ( next_char_isa('.') )
                parse_dec_fraction();

            else if ( next_char_isa('x') )
            {
                next_char_mustbe('x');
                next_char_mustbe(cg_hex_digit);

                while ( next_char_isa(cg_hex_digit) )
                    next_char_mustbe(cg_hex_digit);

                if ( next_char_isa('.') )
                    parse_hex_fraction();
            }
        }

        else if ( next_char_isa(cg_decimal19) )
        {
            next_char_mustbe(cg_decimal19);

            while ( next_char_isa(cg_dec_digit) )
                next_char_mustbe(cg_dec_digit);

            if ( next_char_isa('.') )
                parse_dec_fraction();
        }

    }

    // greek    ::= all unicode code-points from 0x370 to 0x3FF and 0x1F00 to 0x1FFF

    // * string ::= '"' instring* '"'
    static void parse_string()
    {
        next_char_mustbe('"');

        while ( next_char_isa(cg_instring) )
            next_char_mustbe(cg_instring);

        next_char_mustbe('"');
    }

    // * symbol ::= '@'|';'|':'|'!='|','|'.'|'=='|'<=>'|'{'|'}'|'('|')'|'['|']'|'/'
    static void parse_symbol()
    {
        if ( next_char_isa('@') )
            next_char_mustbe('@');

        else if ( next_char_isa(';') )
            next_char_mustbe(';');

        else if ( next_char_isa(':') )
            next_char_mustbe(':');

        else if ( next_char_isa(',') )
            next_char_mustbe(',');

        else if ( next_char_isa('.') )
            next_char_mustbe('.');

        else if ( next_char_isa('{') )
            next_char_mustbe('{');

        else if ( next_char_isa('}') )
            next_char_mustbe('}');

        else if ( next_char_isa('(') )
            next_char_mustbe('(');

        else if ( next_char_isa(')') )
            next_char_mustbe(')');

        else if ( next_char_isa('[') )
            next_char_mustbe('[');

        else if ( next_char_isa(']') )
            next_char_mustbe(']');

        else if ( next_char_isa('/') )
        {
            next_char_mustbe('/');

            // here are the cases of eol comment and adhoc comment

            if ( next_char_isa('/') )
            {
                next_char_mustbe('/');

                while ( next_char_isa(cg_eol_char) )
                    next_char_mustbe(cg_eol_char);

                next_char_mustbe('\n');
            }

            // adhoc_suffix ::= '*' not_star* '*'+ (not_div not_star* '*'+)* '/'

            else if ( next_char_isa('*') )
            {
                next_char_mustbe('*');

                while ( next_char_isa(cg_not_star) )
                    next_char_mustbe(cg_not_star);

                next_char_mustbe('*');

                while ( next_char_isa('*') )
                    next_char_mustbe('*');

                while ( next_char_isa(cg_not_div) )
                {
                    next_char_mustbe(cg_not_div);

                    while ( next_char_isa(cg_not_star) )
                        next_char_mustbe(cg_not_star);

                    next_char_mustbe('*');

                    while ( next_char_isa('*') )
                        next_char_mustbe('*');
                }

                next_char_mustbe('/');
            }
        }

        else if ( next_char_isa('!') )
        {
            next_char_mustbe('!');
            next_char_mustbe('=');
        }

        else if ( next_char_isa('=') )
        {
            next_char_mustbe('=');
            next_char_mustbe('=');
        }

        else if ( next_char_isa('<') )
        {
            next_char_mustbe('<');

            while ( next_char_isa('=') )
                next_char_mustbe('=');

            next_char_mustbe('>');
        }

        else
            did_not_find_char(cg_symbol);
    }


    // token ::= ...
    static void parse_token()
    {
        // token includes wspace, identifier, number, string and so on

        if ( next_char_isa(cg_wspace) ) parse_wspace() ; else
        if ( next_char_isa(cg_identifier) ) parse_identifier() ; else
        if ( next_char_isa(cg_number) ) parse_number() ; else
        if ( next_char_isa(cg_string) ) parse_string() ; else
        if ( next_char_isa(cg_symbol) ) parse_symbol() ; else
        if ( next_char_isa(EOF) ) ; else
        did_not_find_char(cg_token) ;
    }

    // parse the next token in the input and return a new
    // Token object that describes its kind and spelling
    // Note: you must not call new_token() anywhere else in your program
    // Note: you should not modify this function
    Token read_next_token()
    {
        parse_token() ;

        return new_token() ;
    }
}
