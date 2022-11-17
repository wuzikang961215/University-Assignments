// convert Text into Tokens wrapped up in XML
#include "iobuffer.h"
#include "tokeniser-extras.h"
#include <unordered_map>
#include <iostream>
#include <vector>

// to shorten the code
using namespace std ;
using namespace CS_IO_Buffers ;

namespace Exam_Tokeniser
{

    // check if a char matches another char or is a member of a character group
    // eg token_is(tk_colon,tk_colon) returns true
    // eg token_is(tk_sub,tg_op) returns true
    bool char_isa(int ch,int cg)
    {
        if ( ch == cg ) return true ;

        switch(cg)
        {
        case cg_wspace:         // could ch start grammar rule wspace?
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

        case cg_isolated:       // could ch start grammar rule isolated?
            switch(ch)
            {
            case '@':
            case ']':
            case '(':
            case ';':
                return true ;
            default:
                return false ;
            }

        case cg_mixed:          // could ch start grammar rule mixed?
            switch(ch)
            {
            case '+':
            case '!':
            case '-':
            case '<':
            case '/':
                return true ;
            default:
                return false ;
            }

        case cg_note:           // could ch start grammar rule note?
            switch(ch)
            {
            case '#':
            case '/':
                return true ;
            default:
                return false ;
            }

        case cg_hex:            // could ch start grammar rule hex?
            switch(ch)
            {
            case '0' ... '9':
            case 'a' ... 'f':
                return true ;
            default:
                return false ;
            }

        case cg_eol_char:       // could ch start grammar rule eol_char?
            switch(ch)
            {
            case '\t':
            case ' ' ... '~':
                return true ;
            default:
                return false ;
            }

        case cg_adhoc_char:     // could ch start grammar rule adhoc_char?
            switch(ch)
            {
            case '\n':
            case '\r':
            case '\t':
            case ' ' ... '~':
                return true ;
            default:
                return false ;
            }

        case cg_digit:          // could ch start grammar rule digit?
            switch(ch)
            {
            case '0' ... '9':
                return true ;
            default:
                return false ;
            }

        case cg_letter:         // could ch start grammar rule letter?
            switch(ch)
            {
            case 'a' ... 'z':
            case 'A' ... 'Z':
                return true ;
            default:
                return false ;
            }

        case cg_alnum:          // could ch start grammar rule alnum?
            switch(ch)
            {
            case 'a' ... 'z':
            case 'A' ... 'Z':
            case '0' ... '9':
                return true ;
            default:
                return false ;
            }

        default:
            return false ;
        }
    }

    // work out the kind of a parsed token
    // the spelling is a valid token
    // this is called by new_token()
    TokenKind classify_spelling(string spelling)
    {
        if ( spelling == "" ) return tk_eoi ;

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

            case ']':
                return tk_rsb;

            case '(':
                return tk_lrb;

            case ';':
                return tk_semi;

            case '+':
                return tk_add;

            case '!':
                if ( spelling[1] == '=' )
                    return tk_ne;
            
            case '-':
                if ( spelling[1] == '-' )
                    return tk_dec;
            
            case '<':
                if ( spelling[1] == '=' )
                    return tk_spaceship;
                else
                    return tk_lt;

            case '/':
                if ( spelling[1] == '*' )
                {
                    if (spelling[2] == '*')
                        return tk_javadoc;
                }
                else if( spelling.length() == 1)
                    return tk_divide;

            case '&':
                return keyword_or_identifier(spelling);

            case '0':
                return tk_number;

            case '#':
                if( spelling[spelling.length() - 1] == '\n' )
                    return tk_cpp;
        }

        return tk_oops ;
    }

    // work out the correct spelling to use in the Token object being created by new_token()
    // the spelling is a valid token and kind is the token's kind
    // this is called by new_token()
    string correct_spelling(TokenKind kind,string spelling)
    {
        if ( spelling == "" ) return "" ;

        if ( kind == tk_cpp )
        {
            spelling.erase(spelling.begin());
	        spelling.pop_back();
        }

        else if ( kind == tk_javadoc )
        {
            spelling.erase(spelling.begin());
            spelling.erase(spelling.begin());
            spelling.erase(spelling.begin());
	        spelling.pop_back();
            spelling.pop_back();
        }

        return spelling ;
    }

}
