#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define nl << '\n'

string a, ans, q;
ll b, c, aa;

ll to_10 (string num, ll x){
	ll res = 0, st = 1;
	for (int i = num.size()-1; i >= 0; i--){
		if ((int)(num[i]) >= 48 && (int)(num[i]) <= 57){
			res += (int)(num[i] - 48) * st;
		} else{
			res += (int)(num[i] - 65 + 10) * st;
		}
		st *= b;
	}
	return res;
}

void from_10 (ll num, ll x){
	char cc;
	while(num > 0){
		int tmp = num % x;
		num /= x;
		if (tmp < 10){
			cc = (char)(48 + tmp);
		} else{
			cc = (char)(65 + tmp - 10);
		}
		ans.push_back(cc);
	}
	reverse(ans.begin(), ans.end());
}

void fib(){
	string a1, b1; int c1;
	cout << "Enter the number you want to transfer\n"; // Введите число, которое хотите перевести
	cin >> a1;
	cout << "Enter the number system from which you want to transfer\n"; // Введите систему счисления из которой хотите перевести
	cin >> b1;
	cout << "Enter the number system to which you want to transfer\n"; // Введите систему счисления в которую хотите перевести
	cin >> c1;

	int arr[101]; arr[1] = 1; arr[2] = 2;
	for (int i = 3; i <= 100; i++)
		arr[i] = arr[i-1] + arr[i-2];
	int cnt = 0, res = 0;
	for (int i = a1.size()-1; i >= 0; i--){
		cnt++;
		if (a1[i] == '1')
			res += arr[cnt];
	}
	from_10(res, c1);
	cout << "Result: " << ans;
}

signed main(){

	cout << "Do you want to use specific number system (fib)? [yes|no]\n";
	cin >> q;
	if (q == "yes"){
		fib();
		return 0;
	}

	cout << "Enter the number you want to transfer\n"; // Введите число, которое хотите перевести
	cin >> a;
	cout << "Enter the number system from which you want to transfer\n"; // Введите систему счисления из которой хотите перевести
	cin >> b;

	aa = to_10(a, b);

	cout << "Enter the number system to which you want to transfer\n"; // Введите систему счисления в которую хотите перевести
	cin >> c;

	from_10(aa, c);
	cout << "Result: " << ans;

	return 0;
}