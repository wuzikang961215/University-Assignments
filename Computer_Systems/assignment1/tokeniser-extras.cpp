#include "iobuffer.h"
#include "tokeniser-extras.h"

// Author name: Zikang, Wu
// Sudent ID: a1816094

// to shorten the code
using namespace std ;
using namespace CS_IO_Buffers ;

namespace Assignment_Tokeniser
{
    // check if a char matches another char or is a member of a character group
    // eg char_isa('3',cg_digit) returns true 
    bool char_isa(int ch,int cg)
    {
        // single character groups use their character as their value
        // do not add them to the switch statement

        if ( ch == cg ) return true ;

        switch( cg )
        {
            case cg_wspace:              // characters that start rule wspace
                switch(ch)
                {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        return true ;
                    default:
                        return false ;
                }
            case cg_token:              // characters that start rule token
                switch(ch)
                {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                    case 'a' ... 'z':
                    case 'A' ... 'Z':
                    case '^':
                    case '0' ... '9':
                    case '"':
                    case '@':
                    case ';':
                    case ':':
                    case '!':
                    case ',':
                    case '.':
                    case '=':
                    case '<':
                    case '>':
                    case '(':
                    case ')':
                    case '{':
                    case '}':
                    case '[':
                    case ']':
                    case '/':
                        return true ;
                    default:
                        return false ;
                }

            case cg_identifier:         // characters that start rule identifier
                switch(ch)
                {
                    case 'a' ... 'z':
                    case 'A' ... 'Z':
                    case '^':
                        return true ;
                    default:
                        return false ;
                }

            case cg_id_letter:          // characters that start rule id_letter
                switch(ch)
                {
                    case 'a' ... 'z':
                    case 'A' ... 'Z':
                    case '0' ... '9':
                    case '_':
                    case '$':
                    case '.':
                        return true ;
                    default:
                        return false ;
                }

            case cg_number:             // characters that start rule number
                switch(ch)
                {
                    case '0' ... '9':
                        return true ;
                    default:
                        return false ;
                }
                    
            case cg_bin_digit:          // characters that start rule bin_digit
                switch(ch)
                {
                    case '1':
                    case '0':
                        return true ;
                    default:
                        return false ;
                }

            case cg_oct_digit:          // characters that start rule oct_digit
                switch(ch)
                {
                    case '0' ... '7':
                        return true ;
                    default:
                        return false ;
                }

            case cg_decimal:            // characters that start rule decimal
                switch(ch)
                {
                    case '0' ... '9':
                        return true ;
                    default:
                        return false ;
                }

            case cg_decimal19:          // characters that start rule decimal19
                switch(ch)
                {
                    case '1' ... '9':
                        return true ;
                    default:
                        return false ;
                }

            case cg_dec_digit:          // characters that start rule dec_digit
                switch(ch)
                {
                    case '0' ... '9':
                        return true ;
                    default:
                        return false ;
                }

            case cg_hex_digit:          // characters that start rule hex_digit
                switch(ch)
                {
                    case '0' ... '9':
                    case 'A' ... 'F':
                        return true ;
                    default:
                        return false ;
                }

            case cg_instring:           // characters that start rule instring
                switch(ch)
                {
                    case '#' ... '~':
                    case ' ':
                    case '!':
                    case 0x370 ... 0x3FF:
                    case 0x1F00 ... 0x1FFF:
                        return true ;
                    default:
                        return false ;
                }

            case cg_greek:              // characters that start rule greek
                switch(ch)
                {
                    case 0x370 ... 0x3FF:
                    case 0x1F00 ... 0x1FFF:
                        return true ;
                    default:
                        return false ;
                }

            case cg_string:              // characters that start rule string
                switch(ch)
                {
                    case '"':
                        return true ;
                    default:
                        return false ;
                }

            case cg_eol_char:           // characters that start rule eol_char
                switch(ch)
                {
                    case ' ' ... '~':
                    case '\t':
                    case '\r':
                        return true ;
                    default:
                        return false ;
                }

            case cg_adhoc_char:         // characters that start rule adhoc_char
                switch(ch)
                {
                    case ' ' ... '~':
                    case '\t':
                    case '\n':
                    case '\r':
                        return true ;
                    default:
                        return false ;
                }

            case cg_not_star:           // characters that start rule not_star
                switch(ch)
                {
                    case '+' ... '~':
                    case ' ' ... ')':
                    case '\t':
                    case '\n':
                    case '\r':
                        return true ;
                    default:
                        return false ;
                }

            case cg_eol_comment:           // characters that start rule eol_comment
                switch(ch)
                {
                    case '/':
                        return true ;
                    default:
                        return false ;
                }

            case cg_not_div:            // characters that start rule not_div
                switch(ch)
                {
                    case '0' ... '~':
                    case '+' ... '.':
                    case ' ' ... ')':
                    case '\t':
                    case '\n':
                    case '\r':
                        return true ;
                    default:
                        return false ;
                }

            case cg_symbol:             // characters that start rule symbol
                switch(ch)
                {
                    case '@':
                    case ';':
                    case ':':
                    case '!':
                    case ',':
                    case '.':
                    case '=':
                    case '<':
                    case '(':
                    case ')':
                    case '{':
                    case '}':
                    case '[':
                    case ']':
                    case '/':
                        return true ;
                    default:
                        return false ;
                }
                
            case cg_eoi:
                switch(ch)
                {
                    case EOF:
                        return true ;
                    default:
                        return false ;
                }

            case cg_oops:               //
                return true;

            default:
                return false ;
        }
    }

    // work out the kind of a parsed token, this may call keyword_or_identifier()
    // the spelling is a valid token or "" if at end of input
    TokenKind classify_spelling(string spelling)
    {
        if ( spelling == "" ) return tk_eoi ;

        // work out the kind of a parsed token by the first letter

        switch( spelling[0] )
        { 
            case '\n':
                return tk_newline;

            case '\t':
                return tk_tab;

            case '\r':
                return tk_carriage_return;

            case ' ':
                return tk_space;

            case '@':
                return tk_at;

            case ';':
                return tk_semi;

            case ':':
                return tk_colon;

            case ',':
                return tk_comma;

            case '.':
                return tk_dot;

            case '{':
                return tk_lcb;
            case '}':
                return tk_rcb;

            case '(':
                return tk_lrb;

            case ')':
                return tk_rrb;

            case '[':
                return tk_lsb;

            case ']':
                return tk_rsb;

            case '/': 

            // '/' can start 3 rules: symbol, eol_comment and adhoc_comment

                if ( spelling.length() == 1 )
                    return tk_div;

                else
                {
                    if ( spelling[1] == '/' )
                        return tk_eol_comment;

                    else if ( spelling[1] == '*' )
                        return tk_adhoc_comment;
                }

            case '!':
                return tk_ne;

            case '=':
                return tk_eq;

            case '<':
            case '>':
                return tk_spaceship;

            case '"':
                return tk_string;

            case 'a' ... 'z': 
            case 'A' ... 'Z': 
            case '^':
                return keyword_or_identifier(spelling);

            // '0' can start 4 rules, binary, octal, decimal and hexadecimal
            case '0' ... '9':   
                return tk_number;
        }

        return tk_identifier ;
    }

    // work out the correct spelling to use in the Token object being created by new_token()
    // the spelling is a valid token and kind is its kind  
    string correct_spelling(TokenKind kind,string spelling)
    {
        if ( spelling == "" ) return "" ;

        if ( kind == tk_string )
        {
            // get rid of the " "
        
            for ( int i = 0; i < spelling.length(); i++ ) 
            {
                if ( spelling[i] == '"' )
                {
                    if ( i == spelling.length() - 1 )
                        spelling.pop_back();

                    else
                    {
                        for ( int j = i; j < spelling.length()-1; j++ )
                            spelling[j] = spelling[j+1];

                        spelling.pop_back();  
                    }              
                }
            }            
        }

        if ( kind == tk_eol_comment )
        {
            
            // get rid of the \n 
            for ( int i = 0; i < spelling.length() - 2; i++ ) 
                spelling[i] = spelling[i+2];

            spelling.pop_back();
            spelling.pop_back();
            spelling.pop_back();
        }
         
        if ( kind == tk_adhoc_comment )
        {
            // get rid of the  /* 

            for ( int i = 0; i < spelling.length() - 2; i++ ) 
                spelling[i] = spelling[i+2];

            spelling.pop_back();
            spelling.pop_back();
            spelling.pop_back();
            spelling.pop_back();
        }      

        // get rid of the 0s for example 134.000
        if (kind == tk_number)  
        {
            
            // check if it's 000
            int dot = 0; 

            for ( int i = 0; i < spelling.length(); i++ )
            {
                if ( spelling[i] == '.' )
                    dot++;
            }

            // if there is no .
            if ( dot == 0 )    
                return spelling;

            for ( int i = spelling.length() - 1; i >= 0; i-- )
            {
                if ( spelling[i] == '0' && spelling.length() != 1 )
                    spelling.pop_back();

                 // if it's not 0
                else         
                    break;
            }

            // if after pop it's something like 35442.
            if ( spelling[spelling.length() - 1] == '.' ) 
                spelling.pop_back();

        }

        return spelling ;
    }
}
