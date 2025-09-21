#include <iostream>
using namespace std;

// Sum of digits of a number

int main() {

    int n;
    cout << "Enter the number: ";
    cin >> n;
    int sum = 0;
    while(n!=0) {
        int rem = n%10;
        n = n/10;
        sum = sum + rem;
    }
    cout << sum;
    return 0;
}