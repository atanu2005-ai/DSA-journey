#include <iostream>
using namespace std;

// fibonacci series till the number n

int main() {

    int n;
    cout << "Enter the number: ";
    cin >> n;
    int a = 0;
    int b = 1;
    cout << a << " ";
    cout << b << " ";
    for(int i= 0; i <= n; i++) {
        int nextnum = a + b;
        cout << nextnum << " ";
        a = b;
        b = nextnum;
    }
    return 0;
}