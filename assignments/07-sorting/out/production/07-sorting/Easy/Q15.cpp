#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> allCellsDistOrder(int rows, int cols, int r, int c) {
	vector<vector<int>> ans;

	map<int, vector<pair<int, int>>> m;

	for (int i=0;i<rows; i++){
		for(int j=0;j<cols ;j++){
			int dis = abs(r-i) + abs(c-j);
			m[dis].push_back({i,j});
		}
	}

	for (auto i : m) {
		for (auto j : i.second){
			vector<int> t;
			t.push_back(j.first);
			t.push_back(j.second);

			ans.push_back(t);
		}
	}
	return ans;
}
