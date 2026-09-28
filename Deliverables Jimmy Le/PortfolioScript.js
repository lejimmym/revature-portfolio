fetch("https://pokeapi.co/api/v2/pokemon/zoroark")
    .then(response => response.json())
    .then(data => {
        document.getElementById("pokemon-name-visual").textContent = formatPokemonName(data.name);
        document.getElementById("pokemon-image-visual").src = data.sprites.front_default; 
    });
fetch("https://pokeapi.co/api/v2/pokemon/gengar-mega")
    .then(response => response.json())
    .then(data => {
        document.getElementById("pokemon-name-ace").textContent = formatPokemonName(data.name);
        document.getElementById("pokemon-image-ace").src = data.sprites.front_default; 
    });
fetch("https://pokeapi.co/api/v2/pokemon/feraligatr")
    .then(response => response.json())
    .then(data => {
        document.getElementById("pokemon-name-starter").textContent = formatPokemonName(data.name);
        document.getElementById("pokemon-image-starter").src = data.sprites.front_default; 
    });
fetch("https://pokeapi.co/api/v2/pokemon/jolteon")
    .then(response => response.json())
    .then(data => {
        document.getElementById("pokemon-name-og").textContent = formatPokemonName(data.name);
        document.getElementById("pokemon-image-og").src = data.sprites.front_default; 
    });
fetch("https://pokeapi.co/api/v2/pokemon/rotom")
    .then(response => response.json())
    .then(data => {
        document.getElementById("pokemon-name-profession").textContent = formatPokemonName(data.name);
        document.getElementById("pokemon-image-profession").src = data.sprites.front_default; 
    });
fetch("https://pokeapi.co/api/v2/pokemon/zekrom")
    .then(response => response.json())
    .then(data => {
        document.getElementById("pokemon-name-legend").textContent = formatPokemonName(data.name);
        document.getElementById("pokemon-image-legend").src = data.sprites.front_default; 
    });

function formatPokemonName(name) {
    let parts = name.split("-");

    if (parts.length > 1) {
        let prefix = parts.pop();
        name = prefix + " " + parts.join(" ");
    }

    return name
        .split(" ")
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(" ");
}