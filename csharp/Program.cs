Console.OutputEncoding = System.Text.Encoding.UTF8;

List<string> times = new List<string> { "Atlético-MG", "Cruzeiro", "América-MG", "Villa Nova" };

// RF-01
for (int i = 0; i < times.Count; i++)
{
    Console.WriteLine(i + " - " + times[i]);
}

// RF-02, RF-03 e RF-04
int totalJogos = 0;
for (int i = 0; i < times.Count; i++)
{
    for (int j = 0; j < times.Count; j++)
    {
        if (i != j)
        {
            Console.WriteLine(times[i] + " x " + times[j]);
            totalJogos++;
        }
    }
}
Console.WriteLine("Total de jogos: " + totalJogos);

// RF-05 e RF-06
int totalUnico = 0;
for (int i = 0; i < times.Count; i++)
{
    for (int j = 0; j < times.Count; j++)
    {
        if (i < j)
        {
            Console.WriteLine(times[i] + " x " + times[j]);
            totalUnico++;
        }
    }
}
Console.WriteLine("Total turno único: " + totalUnico);