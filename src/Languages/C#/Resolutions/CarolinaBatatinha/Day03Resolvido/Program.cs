using System;

class Program
{
    public static int ReceberPorcoes()
    {
        while (true)
        {
            if (int.TryParse(Console.ReadLine(), out int porcao) && porcao > 0 && porcao <= 10)
            {
                return porcao;
            }
            else
            {
                Console.Write("Valor inválido. Digite um número de 1 a 10: ");
            }
        }
    }

    public static void Main(string[] args)
    {
        Console.WriteLine("Informe quantas porções (entre 1 e 10) cada convidado consumirá: ");
        Console.Write("Chico: ");
        int chico = ReceberPorcoes();
        Console.Write("Bento: ");
        int bento = ReceberPorcoes();
        Console.Write("Bernardo: ");
        int bernardo = ReceberPorcoes();
        Console.Write("Marina: ");
        int marina = ReceberPorcoes();
        Console.Write("Iara: ");
        int iara = ReceberPorcoes();

        int quantidadeMandioca = (chico * 300) + (bento * 1500) + (bernardo * 600) + (marina * 1000) + (iara * 150) + 225;

        Console.WriteLine($"Marlene precisará comprar {quantidadeMandioca} gramas para a festa desse ano.");
    }
}
