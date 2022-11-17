#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <stdlib.h>
#include <math.h>

using namespace std;

string add(string int1, string int2, int base){
    string added; // to store the value after addition
    int carry = 0;
    // add zeros if the size of two numbers are not equal
    if(int1.length() > int2.length()){
        for(std::vector<float>::size_type i = int2.length(); i < int1.length(); i++)
            int2.append("0");
    }
    if(int2.length() > int1.length()){
        for(std::vector<float>::size_type i = int1.length(); i < int2.length(); i++)
            int1.append("0");
    }

    for(std::vector<float>::size_type i = 0; i < int1.length(); i++){
        int numi1 = int1[i] - '0';
        int numi2 = int2[i] - '0';
        if(numi1 + numi2 + carry >= base){
            added.append(to_string(numi1 + numi2 + carry - base));
            carry = 1;
        }
        else{
            added.append(to_string(numi1 + numi2 + carry));
            carry = 0;
        }
    }     

    if(carry == 1)
        added.append("1");
    
    return added;
}

// get sub string
string sub(string input, int begin, int end){
    string sub;
    for(int i = begin; i < end; i++)
        sub += input[i];
    return sub;
}

// subtract function
string subtraction(string int1, string int2, int base){
    string subtract;
    int carry = 0;

    if(int1.length() > int2.length()){
        for(std::vector<float>::size_type i = int2.length(); i < int1.length(); i++)
            int2.append("0");
    }

    for(std::vector<float>::size_type i = 0; i < int2.length(); i++){
        int numi1 = int1[i] - '0';
        int numi2 = int2[i] - '0';
        if(numi1 - numi2 - carry < 0){
            subtract.append(to_string(base - numi2 + numi1 - carry));
            carry = 1;
        }
        else{
            subtract.append(to_string(numi1 - numi2 - carry));
            carry = 0;
        }
    }
    // calculate 0s
    std::vector<float>::size_type num0 = 0;
    for(std::vector<float>::size_type i = subtract.length() - 1; i>=0; i--){
        if(subtract[i] == '0')
            num0++;
        else
            break;
    }
    // get rid of 0s
    if(num0 != 0){
        if(num0 == subtract.length())
            subtract = "0";
        else
            subtract = subtract.substr(0, subtract.length() - num0);
    }
    
    return subtract;
}

// int * B^k
string baseM(string integer, int k){
    string result;
    if(integer == "0")
        return "0";
    for(int i = 0; i < k; i++){
        result.append("0");
    }
    result.append(integer);
    return result;
}

// reverse string
string reverse(string input){
    string output;
    for(int i = input.length() - 1; i >= 0; i--)
        output += input[i];
    return output;
}

// karatsuba multiplication, a is integer1, b is integer2
string multi(string a, string b, int base){
    string result;
    if(a.length() == 1 && b.length() == 1){
        int numa = a[0] - '0';
        int numb = b[0] - '0';
        if(numa * numb >=base){
            result.append(to_string(numa*numb%base));
            result.append(to_string(numa*numb/base));
        }
        else
            result.append(to_string(numa*numb));
    } 
    else
    {
        if(a.length() > b.length()){
            for(std::vector<float>::size_type i = b.length(); i < a.length(); i++)
                b.append("0");
        }
        if(b.length() > a.length()){
            for(std::vector<float>::size_type i = a.length(); i < b.length(); i++)
                a.append("0");
        }
        // split a and b in half
        int middle = a.length()/2;
        string a0 = sub(a, 0 ,middle);
        string a1 = sub(a, middle, a.length());
        string b0 = sub(b, 0 ,middle);
        string b1 = sub(b, middle, b.length());

        result = add(add(baseM(multi(a1, b1, base), middle*2), baseM(subtraction(multi(add(a1, a0, base), add(b1, b0, base), base), add(multi(a1, b1, base), multi(a0, b0, base), base), base), middle), base), multi(a0, b0, base), base);

        // result = add(add(add(baseM(multi(a1, b1, base), middle*2), baseM(multi(a0, b1, base), middle), base), baseM(multi(a1, b0, base), middle), base), multi(a0, b0, base), base);
    }
    return result;
    
}

int main(){    
    string integer1;
    string integer2;
    int base;
    // accept input
    cin >> integer1 >> integer2 >> base;

    string karatsuba = multi(reverse(integer1), reverse(integer2), base);

    // get rid of the zeros 
    std::vector<float>::size_type numZero = 0;
    for(std::vector<float>::size_type i = karatsuba.length()-1; i >= 0; i--){
        if(karatsuba[i] == '0')
            numZero++;
        else
            break;
    }
    if(numZero != 0)
        karatsuba.erase(karatsuba.length() - numZero);
    
    cout << reverse(add(reverse(integer1), reverse(integer2), base)) << " ";

    cout << reverse(karatsuba) ;


    return 0;
}