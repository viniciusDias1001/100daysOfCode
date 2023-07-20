Console.Write("Digite o primeiro número inteiro: ");
int X = Convert.ToInt32(Console.ReadLine());
Console.Write("Digite o segundo número inteiro: ");
int Y = Convert.ToInt32(Console.ReadLine());

double divisao = X / Y;

if (X % Y > 0)
{
    Console.Write("Divisão imposível");
}
else
{
    Console.Write($"{X} ÷ {Y} = {divisao}");
}