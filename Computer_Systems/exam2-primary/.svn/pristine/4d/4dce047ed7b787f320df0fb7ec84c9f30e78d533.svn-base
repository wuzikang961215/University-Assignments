#include "iobuffer.h"
#include "symbols.h"
#include "tokeniser.h"
#include "abstract-syntax-tree.h"

using namespace std ;

using namespace CS_IO_Buffers ;
using namespace CS_Symbol_Tables ;
using namespace Workshop_Compiler ;

// ignore unused-function warnings in this source file
#pragma clang diagnostic ignored "-Wunused-function"

// the grammar we are recognising
// rules containing text literals are written using the matching tk_* or tg_* names
// TERM: DEFINITION
// program:     statements tk_eoi
// statements:  statement*
// statement:   if | let | sequence | do | switch
// if:          tk_if tk_lrb expression tk_rrb sequence tk_else sequence
// let:         tk_let tk_identifier tk_assign expression tk_semi
// sequence:    tk_lcb statements tk_rcb
// do:          tk_do sequence tk_while tk_lrb expression tk_rrb tk_semi
// switch:      tk_switch tk_lrb expression tk_rrb tk_lcb labelled* tk_rcb
// labelled:    (label tk_colon) | statement
// label:       tk_default | (tk_case expression)
// expression:  term (tg_operator term)?
// term:        tk_identifier | tk_integer | tk_string | proc
// proc:        tk_proc tk_lrb parameters? rtype? tk_rrb sequence
// parameters:  parameter (tk_comma parameter)*
// parameter:   tg_type tk_identifier
// rtype:       tk_arrow tg_type
//
// Token groups for use with have()/have_next()/mustbe()/did_not_find():
// tg_statement - matches any token that can start a statement
// tg_labelled  - matches any token that can start the rule labelled
// tg_label     - matches any token that can start the rule label
// tg_term      - matches any token that can start the rule term
// tg_type      - matches any token that can be used as a type in the parameter or rtype rules
// tg_operator  - matches any token that can be used as an operator in the rule expression


// every parse function returns an abstract syntax tree representing what it has parsed
static ast parse_program() ;
static ast parse_statements() ;
static ast parse_statement() ;
static ast parse_if() ;
static ast parse_let() ;
static ast parse_sequence() ;
static ast parse_do() ;
static ast parse_switch() ;
static ast parse_labelled() ;
static ast parse_label() ;
static ast parse_expression() ;
static ast parse_term() ;
static ast parse_proc() ;
static ast parse_parameters() ;
static ast parse_parameter() ;
static Token parse_rtype() ;

// note: we have added push/pop_error_context() calls so that 
//       you can see part of the call chain when an error occurs
// note: in a declaration the first identifier is the variable type

// *****           DO NOT EDIT THE CODE ABOVE           *****


/////////////////////////////////////////////////////////////////////////////
// ***** COMPLETE THE CODE BELOW TO COMPLETE THE PARSER *****

// In each parse_*() function write code to correctly initialise
// the variables passed to the tree node create*() function

// program: statements tk_eoi
static ast parse_program()
{
    push_error_context("parse_program()") ;

    // a statements node
    ast stats = nullptr ;

    // add parsing code here ...
    stats = parse_statements();
    mustbe(tk_eoi);

    // return a program node
    ast ret = create_program(nullptr,stats) ;
    pop_error_context() ;
    return ret ;
}

// statements: statement*
static ast parse_statements()
{
    push_error_context("parse_statements()") ;

    // a vector of statement nodes
    vector<ast> stats ;

    // add parsing code here ...
    while ( have(tg_statement) )
        stats.push_back(parse_statement());

    // return a statements node
    ast ret = create_statements(stats) ;
    pop_error_context() ;
    return ret ;
}

// statement:  if | let | sequence | do | switch
static ast parse_statement()
{
    push_error_context("parse_statement()") ;

    // a statement node
    ast stat = nullptr ;

    // add parsing code here ...
    if ( have(tk_if) )
        stat = parse_if();
    
    else if ( have(tk_let) )
        stat = parse_let();

    else if ( have(tk_lcb) )
        stat = parse_sequence();
    
    else if ( have(tk_do) )
        stat = parse_do();

    else if ( have(tk_switch) )
        stat = parse_switch();

    // return a statement node
    stat = create_statement(stat) ;
    pop_error_context() ;
    return stat ;
}

// if: tk_if tk_lrb expression tk_rrb sequence tk_else sequence
static ast parse_if()
{
    push_error_context("parse_if()") ;

    // an expression node and statements nodes
    ast expr = nullptr ;
    ast then_stat = nullptr ;
    ast else_stat = nullptr ;

    // add parsing code here ...
    mustbe(tk_if);
    mustbe(tk_lrb);
    expr = parse_expression();
    mustbe(tk_rrb);
    then_stat = parse_sequence();
    mustbe(tk_else);
    else_stat = parse_sequence();

    // return an if else node
    ast ret = create_if_else(expr,then_stat,else_stat) ;
    pop_error_context() ;
    return ret ;
}

// declare a variable of the given type and return the variable's tree node
static ast declare_variable(Token identifier,string vartype,string varsegment) ;

// return the variable's tree node or nullptr if it was not previously declared
static ast lookup_variable(Token identifier) ;

// let: tk_let tk_identifier tk_assign expression tk_semi
static ast parse_let()
{
    push_error_context("parse_let()") ;

    // a variable node and an expression node
    ast id = nullptr ;
    ast expr = nullptr ;

    // NOTES:
    // * the identifier is the name of a variable
    // * declare the variable as being of type "int" in segment "local" if it was not already declared

    // add parsing code here ...
    mustbe(tk_let);
    id = lookup_variable(mustbe(tk_identifier));
    mustbe(tk_assign);
    expr = parse_expression();
    mustbe(tk_semi);

    // return a let node
    ast ret = create_let(id,expr) ;
    pop_error_context() ;
    return ret ;
}

// sequence: tk_lcb statements tk_rcb
static ast parse_sequence()
{
    push_error_context("parse_sequence()") ;

    // a vector of statement nodes
    vector<ast> seq ;

    // add parsing code here ...
    mustbe(tk_lcb);
    // seq.push_back(parse_statements());
    while ( have(tg_statement) )
        seq.push_back(parse_statement());

    mustbe(tk_rcb);

    // return a statements node
    ast ret = create_statements(seq) ;
    pop_error_context() ;
    return ret ;
}

// do: tk_do sequence tk_while tk_lrb expression tk_rrb tk_semi
static ast parse_do()
{
    push_error_context("parse_do()") ;

    // an expression node and a statements node
    ast seq = nullptr ;
    ast expr = nullptr ;

    // add parsing code here ...
    mustbe(tk_do);
    seq = parse_sequence();
    mustbe(tk_while);
    mustbe(tk_lrb);
    expr = parse_expression();
    mustbe(tk_rrb);
    mustbe(tk_semi);

    // return a do node
    ast ret = create_do(expr,seq) ;
    pop_error_context() ;
    return ret ;
}

// switch: tk_switch tk_lrb expression tk_rrb tk_lcb labelled* tk_rcb
static ast parse_switch()
{
    push_error_context("parse_switch()") ;

    // an expression node and a statements node
    ast expr = nullptr ;
    vector<ast> stats ;

    // add parsing code here ...
    mustbe(tk_switch);
    mustbe(tk_lrb);
    expr = parse_expression();
    mustbe(tk_rrb);
    mustbe(tk_lcb);

    while ( have(tg_labelled) )
        stats.push_back(parse_labelled());
    
    mustbe(tk_rcb);

    // return a switch node
    ast ret = create_switch(expr,create_statements(stats)) ;
    pop_error_context() ;
    return ret ;
}

// labelled: (label tk_colon) | statement
static ast parse_labelled()
{
    push_error_context("parse_labelled()") ;

    // a statement node
    ast stat = nullptr ;

    // add parsing code here ...
    if ( have(tg_label) )
    {
        stat = parse_label();
        mustbe(tk_colon);
    }

    else
        stat = parse_statement();

    // return the statement node - parse_label() returns a statement node
    pop_error_context() ;
    return stat ;
}

// label: tk_default | (tk_case expression)
static ast parse_label()
{
    push_error_context("parse_label()") ;

    // a label node and an expression node
    ast expr = nullptr ;

    // add parsing code here ...
    if ( have(tk_default) )
        mustbe(tk_default);

    else
    // if its a case label - execute this block
    {
        mustbe(tk_case);
        expr = parse_expression();
        // return a case label node wrapped in a statement
        ast ret = create_statement(create_case(expr)) ;
        pop_error_context() ;
        return ret ;
    }

    // return a default label node wrapped in a statement
    ast ret = create_statement(create_default()) ;
    pop_error_context() ;
    return ret ;
}

// expression: term (tg_operator term)?
static ast parse_expression()
{
    push_error_context("parse_expression()") ;

    // two term nodes and a Token
    ast lhs = nullptr ;
    ast rhs = nullptr ;
    Token infix_op = nullptr ;

    // add parsing code here ...
    lhs = parse_term();

    if ( have(tg_operator) )
    // if the expression has an infix operator
    {
        infix_op = mustbe(tg_operator);
        rhs = parse_term();
        // return an infix expression node
        ast ret = create_expression(create_infix_op(lhs,token_spelling(infix_op),rhs)) ;
        pop_error_context() ;
        return ret ;
    }

    // return a single term expression node
    ast ret = create_expression(lhs) ;
    pop_error_context() ;
    return ret ;
}

// the following helper functions can be used in parse_term()

// turn an integer token into an ast node
static ast integer_to_ast(Token integer)
{
    return create_int(token_ivalue(integer)) ;
}

// turn a string token into an ast node
static ast string_to_ast(Token astring)
{
    return create_string(token_spelling(astring)) ;
}

// To return the variable's tree node or report a fatal error if it was not previously declared, use:
// ast lookup_variable(Token identifier) ;

// term: tk_identifier | tk_integer | tk_string | proc
static ast parse_term()
{
    push_error_context("parse_term()") ;

    // a variable node, a call node, an integer node, a string node or an expression node
    ast term = nullptr ;

    // add parsing code here ...
    if ( have(tk_identifier) )
        term = string_to_ast(mustbe(tk_identifier));

    else if ( have(tk_integer) )
        term = integer_to_ast(mustbe(tk_integer));

    else if ( have(tk_string) )
        term = string_to_ast(mustbe(tk_string));

    else if ( have( tk_proc) )
        term = parse_proc();

    // return the term parsed wrapped in a term node
    ast ret = create_term(term) ;
    pop_error_context() ;
    return ret ;
}

// proc:        tk_proc tk_lrb parameters? rtype? tk_rrb sequence
// use "void" for the rtype if it is not present
static ast parse_proc()
{
    push_error_context("parse_proc()") ;

    // a procedure node
    ast parameters = nullptr ;
    string rtype = "void" ;
    ast body = nullptr ;

    mustbe(tk_proc);
    mustbe(tk_lrb);
    
    if ( have(tg_type) )
        parameters = parse_parameters();

    if ( have(tk_arrow) )
        rtype = token_spelling(parse_rtype());

    mustbe(tk_rrb);
    body = parse_sequence();

    // return the term parsed wrapped in a term node
    ast ret = create_function(rtype,"",parameters,body) ;
    pop_error_context() ;
    return ret ;
}

// parameters:  parameter (tk_comma parameter)*
static ast parse_parameters()
{
    push_error_context("parse_parameters()") ;

    // a vector of parameters
    vector<ast> params ;

    params.push_back(parse_parameter());

    while ( have(tk_comma) )
    {
        mustbe(tk_comma);
        params.push_back(parse_parameter());
    }

    // return the term parsed wrapped in a term node
    ast ret = create_declarations(params) ;
    pop_error_context() ;
    return ret ;
}

// declare a variable of the given type and return the variable's tree node
static ast declare_variable(Token identifier,Token type,string varsegment) ;

// parameter:   tg_type tk_identifier
static ast parse_parameter()
{
    push_error_context("parse_parameter()") ;

    // a variable node returned by declare_variable
    ast var = nullptr ;

    Token type = mustbe(tg_type);
    Token identifier = mustbe(tk_identifier);
    var = declare_variable(identifier, type, "argument");

    // return the parameter a parameter node
    ast ret = create_declaration(var) ;
    pop_error_context() ;
    return ret ;
}

// rtype:       tk_arrow tg_type
static Token parse_rtype()
{
    push_error_context("parse_rtype()") ;
    Token rtype = nullptr ;

    mustbe(tk_arrow);
    rtype = mustbe(tg_type);

    // return the token for the return type
    pop_error_context() ;
    return rtype ;
}

/////////////////////////////////////////////////////////////////////////////
// ***** DO NOT CHANGE CODE AFTER THIS POINT *****

// ****  SYMBOL TABLES  ****

// scope levels each have their own symbol tables, segment and next free location
static jsymbols symbol_tables ;

// initialise the symbol tables
static void initialise_symbol_tables()
{
    symbol_tables = nullptr ;
}

// push a new symbol table onto the stack of symbol tables
static void push_symbol_table()
{
    symbol_tables = jsymbols_push(symbol_tables) ;
}

// pop the top scope from the stack of symbol tables and delete it
static void pop_symbol_table()
{
    symbol_tables = jsymbols_pop(symbol_tables) ;
}

// this function adds an identifier to the top symbol table on the symbol table stack
// it allocates the variable the next free offset in its segment
// it returns a tree node representing the variable
static ast declare_variable(Token identifier,string vartype,string varsegment)
{
    string varname = token_spelling(identifier) ;
    int varoffset = jsymbols_offset(symbol_tables,varsegment) ;

    if ( !jsymbols_insert(symbol_tables,varname,vartype,varsegment,varoffset) ) // it is an error to declare something twice
    {
        fatal_error(0,"\n" + token_context(identifier) + "Variable:  " + varname +  " has already been declared") ;
    }

    return create_variable(varname,varsegment,varoffset,vartype) ;
}

// alternate interface using Token for the type
static ast declare_variable(Token identifier,Token vartype,string varsegment)
{
    return declare_variable(identifier,token_spelling(vartype),varsegment) ;
}

// lookup the identifier, it is an error if it was not previously declared
// it returns a tree node representing the variable
static ast lookup_variable(Token identifier)
{
    // search symbol tables from top to bottom of the symbol table stack
    string varname = token_spelling(identifier) ;
    jack_var var = jsymbols_lookup(symbol_tables,varname) ;
    if ( var != nullptr )
    {
        return create_variable(varname,jack_var_segment(var),jack_var_offset(var),jack_var_type(var)) ;
    }

    // variables not found - report a fatal error - the return is just so that the function compiles
    fatal_error(0,"\n" + token_context(identifier) + "Found undeclared variable:  " + varname) ;
    return nullptr ;
}


// **** MAIN PROGRAM ****

// main program for workshop 10/11 parser to XML
int main(int argc,char **argv)
{
    config_output(iob_immediate) ;      // make all output and errors appear immediately
    config_errors(iob_immediate) ;

    initialise_symbol_tables() ;        // initialise symbol tables
    push_symbol_table() ;               // push a new symbol table to hold declarations

    next_token() ;                      // read first token to initialise tokeniser
    ast program = parse_program() ;      // parse a Program to get a parse tree

    pop_symbol_table() ;                // delete the symbol table

    ast_print_as_xml(program,2) ;       // write the tree to standard output formatted as XML

    // flush the output and any errors
    print_output() ;
    print_errors() ;
}

