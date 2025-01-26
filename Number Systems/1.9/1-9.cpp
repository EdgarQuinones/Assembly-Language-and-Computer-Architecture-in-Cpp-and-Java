// Section 1.9
// Page 18
// Figure 1.6

#include <iostream>
using namespace std;
int main() 
{
    char c;
    c = -1;
    if (c == -1) // May not result in true based on compiler
        cout << "equal\n"; // Always equal when c is signed 
    else
        cout << "not equal\n"; 
    return 0;
}