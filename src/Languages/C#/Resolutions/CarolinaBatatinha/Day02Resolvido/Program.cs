Console.Write("\nInforme a distância entre as motos X e Y em km: ");
int k = Convert.ToInt32(Console.ReadLine());

double tempo = (double)k * 2;

Console.WriteLine($"O tempo necessário para a moto Y ficar {k}km distante da moto X é de {tempo} minutos.");
