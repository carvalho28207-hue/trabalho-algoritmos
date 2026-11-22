fn main() {
    let times: Vec<String> = vec![
        String::from("Atlético-MG"),
        String::from("Cruzeiro"),
        String::from("América-MG"),
        String::from("Villa Nova"),
    ];

    // RF-01
    for i  in 0..times.len() {
        println!("{} - {}", i, times[i]);
    }

    // RF-02, RF-03 e RF-04
    let mut total_jogos = 0;
    for i in 0..times.len() {
        for j in 0..times.len() {
            if i !=j {
                println!("{} x {}", times[i], times[j]);
                total_jogos += 1;
            }
        }
    }
    println!("Total de jogos: {}", total_jogos);

    // RF-05 e RF-06
    let mut total_unico = 0;
    for i in 0..times.len() {
        for j in 0..times.len() {
            if i < j {
                println!("{} x {}", times[i], times[j]);
                total_unico += 1;
            }
        }
    }
    println!("Total turno único: {}", total_unico);
}
