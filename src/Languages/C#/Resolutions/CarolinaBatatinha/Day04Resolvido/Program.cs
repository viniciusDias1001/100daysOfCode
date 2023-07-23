using System;

class Program
{
    public static int LerNumero()
    {
        while(true)
        {
            if(int.TryParse(Console.ReadLine(),out int N) && N > 0 && N <=1000)
            {
                return N;
            }
            else
            {
                Console.WriteLine("Digite um valor válido.");
            }
        }
    }
    public static void Main(string[] args)
    {
        Console.Write("Digite um valor inteiro entre 1 e 1000: ");
        int N = LerNumero();

        for (int i = 1; i <= N; i++)
        {
            int quadrado = Convert.ToInt32(Math.Pow(i, 2));
            int cubo = Convert.ToInt32(Math.Pow(i, 3));
            Console.WriteLine($"{i} {quadrado} {cubo}\n");
        }
    }
}
