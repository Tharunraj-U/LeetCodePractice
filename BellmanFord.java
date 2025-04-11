class BellmanFord {
    static int[] bellmanFord(int V, int[][] edges, int src) {
       int dis[]=new int[V];
       Arrays.fill(dis, 100000000); 
       dis[src]=0;
       while(V-- > 1){
        for(int arr[]:edges){
            if(dis[arr[0]] != 100000000 && (dis[arr[0]]+arr[2])<dis[arr[1]]){
                dis[arr[1]]=dis[arr[0]]+arr[2];
            }
        }
       }
        for(int arr[]:edges)if( dis[arr[0]] != 100000000 && (dis[arr[0]]+arr[2])<dis[arr[1]])return new int[]{-1};
        
       return dis;
    }
}