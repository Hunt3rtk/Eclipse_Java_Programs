
public class Graph {

	//initializing the distances and the graph edges
	static int gva [][] = new int [13][13];
	static boolean edge [][] = new boolean [13][13];
	
	//giving the city id's
	static int WV = 0;
	static int NV = 1;
	static int V = 2;
	static int R = 3;
	static int D = 4;
	static int B = 5;
	static int NW = 6;
	static int S = 7;
	static int L = 8;
	static int A = 9;
	static int M = 10;
	static int C = 11;
	static int H = 12;
	
	//distance inizializer
	static void GVA() {
		
		//going no where
		for(int i = 0; i <= 12; i++)
		{
			gva[i][i] = 0;
		}
		
		//all cities distances from eachother
		gva[WV][NV] = 9;
		gva[WV][V] = 8;
		gva[WV][R] = 24;
		gva[WV][D] = 49;
		gva[WV][B] = 22;
		gva[WV][NW] = 30;
		gva[WV][S] = 43;
		gva[WV][L] = 56;
		gva[WV][A] = 80;
		gva[WV][M] = 84;
		gva[WV][C] = 112;
		gva[WV][H] = 162;
		gva[NV][V] = 10;
		gva[NV][R] = 29;
		gva[NV][D] = 36;
		gva[NV][B] = 14;
		gva[NV][NW] = 27;
		gva[NV][S] = 36;
		gva[NV][L] = 48;
		gva[NV][A] = 73;
		gva[NV][M] = 77;
		gva[NV][C] = 104;
		gva[NV][H] = 154;
		gva[V][R] = 16;
		gva[V][D] = 25;
		gva[V][B] = 14;
		gva[V][NW] = 26;
		gva[V][S] = 30;
		gva[V][L] = 47;
		gva[V][A] = 72;
		gva[V][M] = 77;
		gva[V][C] = 103;
		gva[V][H] = 153;
		gva[R][D] = 14;
		gva[R][B] = 21;
		gva[R][NW] = 21;
		gva[R][S] = 30;
		gva[R][L] = 47;
		gva[R][A] = 75;
		gva[R][M] = 79;
		gva[R][C] = 110;
		gva[R][H] = 160;
		gva[D][B] = 29;
		gva[D][NW] = 22;
		gva[D][S] = 19;
		gva[D][L] = 33;
		gva[D][A] = 64;
		gva[D][M] = 70;
		gva[D][C] = 99;
		gva[D][H] = 150;
		gva[B][NW] = 7;
		gva[B][S] = 13;
		gva[B][L] = 34;
		gva[B][A] = 59;
		gva[B][M] = 54;
		gva[B][C] = 89;
		gva[B][H] = 140;
		gva[NW][S] = 7;
		gva[NW][L] = 27;
		gva[NW][A] = 53;
		gva[NW][M] = 53;
		gva[NW][C] = 84;
		gva[NW][H] = 134;
		gva[S][L] = 24;
		gva[S][A] = 46;
		gva[S][M] = 47;
		gva[S][C] = 76;
		gva[S][H] = 126;
		gva[L][A] = 31;
		gva[L][M] = 35;
		gva[L][C] = 62;
		gva[L][H] = 112;
		gva[A][M] = 12;
		gva[A][C] = 34;
		gva[A][H] = 84;
		gva[M][C] = 43;
		gva[M][H] = 93;
		gva[C][H] = 52;
		
		//all edges on graph
		addEdge(WV,NV);
		addEdge(WV,V);
		addEdge(NV,V);
		addEdge(NV,B);
		addEdge(V,B);
		addEdge(V,R);
		addEdge(R,B);
		addEdge(R,NW);
		addEdge(R,D);
		addEdge(B,NW);
		addEdge(B,S);
		addEdge(NW,S);
		addEdge(S,M);
		addEdge(S,L);
		addEdge(L,M);
		addEdge(L,A);
		addEdge(A,M);
		addEdge(A,C);
		addEdge(M,C);
		addEdge(C,H);
	}
	
	//returns if the edge is on the graph
	static boolean edge(int c1,int c2) {
		return edge[c1][c2];
	}
	
	//creates an edge for the graph
	static void addEdge(int c1,int c2) {
		edge[c1][c2] = true;
	}
}