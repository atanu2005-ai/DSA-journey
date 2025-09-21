#include <iostream>
using namespace std;

// Print a number in reverse order

int main() {

    int n;
    cout << "Enter the number: ";
    cin >> n;
    while(n!=0) {
        int rem = n%10;
        n = n/10;
        cout << rem;
    }    
    return 0;
}