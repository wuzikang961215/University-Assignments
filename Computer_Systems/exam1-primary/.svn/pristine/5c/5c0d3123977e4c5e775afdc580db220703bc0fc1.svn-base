// tokeniser implementation for the workshop example language

#include "tokeniser-extras.h"

// to shorten the code
using namespace std ;

// we are extending the Exam_Tokeniser namespace

namespace Exam_Tokeniser
{
    // Add additonal parsing functions here ...

    // * wspace ::= '\t' | '\n' | '\r' | ' '
    static void parse_wspace()
    {
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

    // isolated ::=        '@' | ']' | '(' | ';'
    static void parse_isolated()
    {

        // if combined with mustbe

        if ( next_char_isa('@') )   
            next_char_mustbe('@');

        else if ( next_char_isa(']') )
            next_char_mustbe(']');

        else if ( next_char_isa('(') )
            next_char_mustbe('(');

        else if ( next_char_isa(';') )
            next_char_mustbe(';');

        else
            did_not_find_char(cg_isolated);
    }

    // mixed ::=           '+' | '!=' | '--' | '<' | '<=>' | '/'
    static void parse_mixed()
    {

        // if combined with mustbe
        if ( next_char_isa('+') )   
            next_char_mustbe('+');

        else if ( next_char_isa('!') )
        {
            next_char_mustbe('!');
            next_char_mustbe('=');
        }

        else if ( next_char_isa('<') )
        {
            next_char_mustbe('<');
            if ( next_char_isa('=') )
            {
                next_char_mustbe('=');
                next_char_mustbe('>');
            }
        }

        else if ( next_char_isa('/') )
        {
            next_char_mustbe('/');

            if(next_char_isa('*'))
            {
                next_char_mustbe('*');
                next_char_mustbe('*');
                while ( next_char_isa(cg_adhoc_char) )
                    next_char_mustbe(cg_adhoc_char);
                next_char_mustbe('*');
                next_char_mustbe('/');
            }
        }

        else
            did_not_find_char(cg_mixed);
    }

    // identifier ::=      '&' letter alnum*
    static void parse_identifier()
    { 
        next_char_mustbe('&');
        next_char_mustbe(cg_letter);

        while ( next_char_isa(cg_alnum) )
            next_char_mustbe(cg_alnum);
    }

    // number ::=          '0x' hex hex*
    static void parse_number()
    { 
        next_char_mustbe('0');
        next_char_mustbe('x');
        next_char_mustbe(cg_hex);

        while ( next_char_isa(cg_hex) )
            next_char_mustbe(cg_hex);
    }

    static void parse_cpp()
    {
        next_char_mustbe('#');
        while ( next_char_isa(cg_eol_char) )
            next_char_mustbe(cg_eol_char);
        next_char_mustbe('\n');
    }

    static void parse_javadoc()
    {
        next_char_mustbe('/');
        next_char_mustbe('*');
        next_char_mustbe('*');
        while ( next_char_isa(cg_adhoc_char) )
            next_char_mustbe(cg_adhoc_char);
        next_char_mustbe('*');
        next_char_mustbe('/');
    }

    // note ::=            cpp | javadoc
    // cpp ::=             '#' eol_char* '\n'
    // javadoc ::=         '/**' adhoc_char* '*/'
    static void parse_note()
    { 
        if ( next_char_isa('#') )
            parse_cpp();

        else if ( next_char_isa('/') )
            parse_javadoc();
            
        else
            did_not_find_char(cg_note);
    }

    // token ::= ...
    static void parse_token()
    {
        // Add your code here ...

        if ( next_char_isa(cg_wspace) ) parse_wspace() ; else
        if ( next_char_isa('&') ) parse_identifier() ; else
        if ( next_char_isa('0') ) parse_number() ; else
        if ( next_char_isa(cg_isolated) ) parse_isolated() ; else
        if ( next_char_isa(cg_mixed) ) parse_mixed() ; else
        if ( next_char_isa(cg_note) ) parse_note() ; else
        if ( next_char_isa(EOF) ) ; else

        // ....

        // catch all error if next character cannot start a token
        fatal_error_context("parse_token() did not find a character that can start a token") ;
    }

    // if not at the end of input, parse the next token in the input and return a new
    // Token object that describes its kind and spelling
    // Note: you must not call new_token() anywhere else in your program
    //
    Token read_next_token()
    {
        if ( !next_char_isa(EOF) ) parse_token() ;

        return new_token() ;
    }
}

