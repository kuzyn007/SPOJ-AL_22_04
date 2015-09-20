/**
 * Autor kodu: Sewery Adamczyk
 * Pochodzenie: http://pl.spoj.com/problems/AL_22_04/
 */

import java.util.*;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); //rozmiar planszy
		int[][] plansza = new int[n][n];
		
		int w = in.nextInt(); //oznaczaj¹ca liczbê pocz¹tkowych wartoœci znajduj¹cych siê na planszy
		for(int i=0; i<w; i++)
		{
			int p = in.nextInt(); //wartoœæ
			int y = in.nextInt(); //wiersz
			int x = in.nextInt(); //kolumna
			
			plansza[y][x] = p;
		}
		/*System.out.println("Plansza podstawowa");
		sprawdzeniePlanszy(plansza);*/
		
		int r = in.nextInt(); //liczba ruchów do wykonania
		int wynik=0;
		for(int i=0; i<r; i++)
		{
			String kierunek = in.next();
			int p = in.nextInt(); //wartoœæ
			int y = in.nextInt(); //wiersz
			int x = in.nextInt(); //kolumna
			
			if(kierunek.equalsIgnoreCase("L"))
			{
				for(int j=0; j<n; j++)
				{
					int pozycja=0;
					int ustawianieTablicy=0;
					for(int k=0; k<n; k++)
					{
						//przygotowanie pozycji liczb
						if(plansza[j][k] == 0)
						{
							continue; //powrot do petli for z warunkiem "k"
						}
						if(k < n-1)
						{
							pozycja = k+1;
							while(pozycja < n-1 && plansza[j][pozycja] == 0)
							{
								pozycja++;
							}
						}
					
						//zakladanie kolejnych procesow co sie stanie z liczbami
						if(plansza[j][k] == plansza[j][pozycja] && k<n-1)
						{
							plansza[j][k] = plansza[j][k] + plansza[j][pozycja];
							plansza[j][pozycja] = 0;
							wynik += plansza[j][k]; //powiekszanie wyniku
						}
						
						//ustawianie nowej tablicy do wybranej krawedzi planszy
						plansza[j][ustawianieTablicy] = plansza[j][k];
						if(k>0 && k != ustawianieTablicy)
						{
							plansza[j][k]=0;
						}
						ustawianieTablicy++;
					}
				}
			}
			
			if(kierunek.equalsIgnoreCase("P"))
			{
				for(int j=n-1; 0<=j; j--)
				{
					int pozycja=n-1;
					int ustawianieTablicy=n-1;
					for(int k=n-1; 0<=k; k--)
					{
						//przygotowanie pozycji liczb
						if(plansza[j][k] == 0)
						{
							continue; //powrot do petli for z warunkiem "k"
						}
						if(k > 0)
						{
							pozycja = k-1;
							while(pozycja > 0 && plansza[j][pozycja] == 0)
							{
								pozycja--;
							}
						}
					
						//zakladanie kolejnych procesow co sie stanie z liczbami
						if(plansza[j][k] == plansza[j][pozycja] && k>0)
						{
							plansza[j][k] = plansza[j][k] + plansza[j][pozycja];
							plansza[j][pozycja] = 0;
							wynik += plansza[j][k]; //powiekszanie wyniku
						}
						
						//ustawianie nowej tablicy do wybranej krawedzi planszy
						plansza[j][ustawianieTablicy] = plansza[j][k];
						if(k<n-1 && k != ustawianieTablicy)
						{
							plansza[j][k]=0;
						}
						ustawianieTablicy--;
					}
				}
			}
			
			if(kierunek.equalsIgnoreCase("G"))
			{
				for(int k=0; k<n; k++)
				{
					int pozycja=0;
					int ustawianieTablicy=0;
					for(int j=0; j<n; j++)
					{
						//przygotowanie pozycji liczb
						if(plansza[j][k] == 0)
						{
							continue; //powrot do petli for z warunkiem "k"
						}
						if(j < n-1)
						{
							pozycja = j+1;
							while(pozycja < n-1 && plansza[pozycja][k] == 0)
							{
								pozycja++;
							}
						}
					
						//zakladanie kolejnych procesow co sie stanie z liczbami
						if(plansza[j][k] == plansza[pozycja][k] && j<n-1)
						{
							plansza[j][k] = plansza[j][k] + plansza[pozycja][k];
							plansza[pozycja][k] = 0;
							wynik += plansza[j][k]; //powiekszanie wyniku
						}
						
						//ustawianie nowej tablicy do wybranej krawedzi planszy
						plansza[ustawianieTablicy][k] = plansza[j][k];
						if(j>0 && j != ustawianieTablicy)
						{
							plansza[j][k]=0;
						}
						ustawianieTablicy++;
					}
				}
			}
			
			if(kierunek.equalsIgnoreCase("D"))
			{
				for(int k=n-1; 0<=k; k--)
				{
					int pozycja=n-1;
					int ustawianieTablicy=n-1;
					for(int j=n-1; 0<=j; j--)
					{
						//przygotowanie pozycji liczb
						if(plansza[j][k] == 0)
						{
							continue; //powrot do petli for z warunkiem "k"
						}
						if(j > 0)
						{
							pozycja = j-1;
							while(pozycja > 0 && plansza[pozycja][k] == 0)
							{
								pozycja--;
							}
						}
					
						//zakladanie kolejnych procesow co sie stanie z liczbami
						if(plansza[j][k] == plansza[pozycja][k] && j>0)
						{
							plansza[j][k] = plansza[j][k] + plansza[pozycja][k];
							plansza[pozycja][k] = 0;
							wynik += plansza[j][k]; //powiekszanie wyniku
						}
						
						//ustawianie nowej tablicy do wybranej krawedzi planszy
						plansza[ustawianieTablicy][k] = plansza[j][k];
						if(j<n-1 && j != ustawianieTablicy)
						{
							plansza[j][k]=0;
						}
						ustawianieTablicy--;
					}
				}
			}
			
			plansza[y][x] = p;
		}
		/*System.out.println("Plansza po zmianie");
		sprawdzeniePlanszy(plansza);*/
		System.out.println(wynik);
		
		in.close();
	}
	
	public static void sprawdzeniePlanszy(int[][] plansza)
	{
		for (int[] wiersz : plansza)
		{
			for (int kolumna : wiersz)
			{
				System.out.print(kolumna + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

