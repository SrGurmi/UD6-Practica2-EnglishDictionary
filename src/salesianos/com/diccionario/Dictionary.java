package salesianos.com.diccionario;

import salesianos.com.utils.Sanitization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private final Map<Character, Set<String>> palabrasPorInicial;

    public Dictionary() {
        this.palabrasPorInicial = new HashMap<>();
    }

    public String agregarPalabra(String palabra) {
        palabra = Sanitization.sanitizar(palabra);
        char inicial = Character.toLowerCase(palabra.charAt(0));

        if (!palabrasPorInicial.containsKey(inicial)) {
            palabrasPorInicial.put(inicial, new	HashSet<>());
        }

        if (palabrasPorInicial.get(inicial).contains(palabra)) {
            return "The word is already added in the dictionary.";
        }

        palabrasPorInicial.get(inicial).add(palabra);
        return "The word was added successfully!";
    }

    public String eliminarPalabra(String palabra) {
        palabra = Sanitization.sanitizar(palabra);
        char inicial = Character.toLowerCase(palabra.charAt(0));

        if (palabrasPorInicial.containsKey(inicial) && palabrasPorInicial.get(inicial).contains(palabra)) {
            palabrasPorInicial.get(inicial).remove(palabra);
            return "Palabra eliminada correctamente.";
        } else {
            return "La palabra no está en el diccionario.";
        }
    }

    public boolean existePalabra(String palabra) {
        palabra = Sanitization.sanitizar(palabra);
        char inicial = Character.toLowerCase(palabra.charAt(0));

        return palabrasPorInicial.containsKey(inicial) && palabrasPorInicial.get(inicial).contains(palabra);
    }

    public Set<Character> inicialesDisponibles() {
        return palabrasPorInicial.keySet();
    }

    public Set<String> palabrasPorInicial(char inicial) {
        inicial = Character.toLowerCase(inicial);
        return palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
    }
}
