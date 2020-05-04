
/**
 *
 * @author Ömer Faruk ERTÜRK
 */
public class MinimumYoluBulma {
    private static final int NO_PARENT = -1; 
    private static void 
    dijkstra(int[][] adjacencyMatrix, int baslangicNoktasi) 
    
    { 
        int nTepe = adjacencyMatrix[0].length; 
        int[] kisaYol = new int[nTepe]; 
        boolean[] added = new boolean[nTepe]; 
 
        for (int vertexIndex = 0; vertexIndex < nTepe; vertexIndex++) 
        {kisaYol[vertexIndex] = Integer.MAX_VALUE; added[vertexIndex] = false; } 
        kisaYol[baslangicNoktasi] = 0; 
        int[] parents = new int[nTepe]; 
        parents[baslangicNoktasi] = NO_PARENT; 
        for (int i = 1; i < nTepe; i++) 
        { 
            int yakinTepe = -1; 
            int enkisaYol = Integer.MAX_VALUE; 
            for (int vertexIndex = 0; 
                     vertexIndex < nTepe;  
                     vertexIndex++) 
            { 
                if (!added[vertexIndex] && 
                    kisaYol[vertexIndex] <  
                    enkisaYol)  
                { 
                    yakinTepe = vertexIndex; 
                    enkisaYol = kisaYol[vertexIndex]; 
                } 
            } 
  
      
            added[yakinTepe] = true; 
      
            for (int vertexIndex = 0; 
                     vertexIndex < nTepe;  
                     vertexIndex++)  
            { 
                int edgeDistance = adjacencyMatrix[yakinTepe][vertexIndex]; 
                  
                if (edgeDistance > 0
                    && ((enkisaYol + edgeDistance) <  
                        kisaYol[vertexIndex]))  
                { 
                    parents[vertexIndex] = yakinTepe; 
                    kisaYol[vertexIndex] = enkisaYol +  
                                                       edgeDistance; 
                } 
            } 
        } 
  
        printSolution(baslangicNoktasi, kisaYol, parents); 
    } 
    private static void printSolution(int baslangicNoktasi, 
                                      int[] distances, 
                                      int[] parents) 
    { 
        int nTepe = distances.length; 
        System.out.print("Nerden Nereye\t Yol Uzunlugu\t Yol"); 
        

          
        for (int vertexIndex = 0;  
                 vertexIndex < nTepe;  
                 vertexIndex++)  
        { 
            if (vertexIndex != baslangicNoktasi)  
            { 
                System.out.print("\n" + baslangicNoktasi + " -> "); 
                System.out.print(vertexIndex + " \t\t "); 
                System.out.print(distances[vertexIndex] + "\t\t"); 
                ekranaYazdirma(vertexIndex, parents); 
                 
            } 
        } 
    } 
    private static void ekranaYazdirma(int currentVertex, 
                                  int[] parents) 
    { 
          
       
        if (currentVertex == NO_PARENT) 
        { 
            return; 
        } 
        ekranaYazdirma(parents[currentVertex], parents); 
        System.out.print(currentVertex + " "); 
    } 
  
    public static void main(String[] args) 
    { 
   
       //Yol haritasını, mesafeleri oluşturuyorum
        int[][] adjacencyMatrix = { 
        { 0, 8, 0, 0, 0, 0, 0, 16, 0 }, 
	{ 8, 0, 16, 0, 0, 0, 0, 22, 0 }, 
	{ 0, 16, 0, 14, 0, 8, 0, 0, 4 }, 
	{ 0, 0, 14, 0, 18, 28, 0, 0, 0 }, 
	{ 0, 0, 0, 18, 0, 20, 0, 0, 0 }, 
	{ 0, 0, 8, 28, 20, 0, 4, 0, 0 }, 
	{ 0, 0, 0, 0, 0, 4, 0, 2, 12 }, 
	{ 18, 22, 0, 0, 0, 0, 2, 0, 14 }, 
	{ 0, 0, 4, 0, 0, 0, 12, 14, 0 } };
        dijkstra(adjacencyMatrix, 0); 
        System.out.print("\n\n Ã–mer Faruk ErtÃ¼rk\t18MY93003");
        

    } 
    
} 
  
