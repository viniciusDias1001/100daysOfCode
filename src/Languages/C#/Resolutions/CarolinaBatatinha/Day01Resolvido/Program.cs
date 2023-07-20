Console.Write("Informe quantos pares de valores inteiros serão lidos: ");
int N = Convert.ToInt32(Console.ReadLine());

for (int i = 0; i < N; i++)
{
    Console.Write("Digite o primeiro número inteiro: ");
    int X = Convert.ToInt32(Console.ReadLine());
    Console.Write("Digite o segundo número inteiro: ");
    int Y = Convert.ToInt32(Console.ReadLine());

    double divisao = (double)X / Y;

    if (Y != 0)
    {
        Console.WriteLine($"\n{X} ÷ {Y} = {divisao:F1}");
    }
    else
    {
        Console.WriteLine("Divisão impossível");
    }
}
