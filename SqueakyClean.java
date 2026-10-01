package squeakyclean;

/**
 * Ejercicio 7: Squeaky Clean
 * Concepto: Strings (Advanced) / Chars (Uso de StringBuilder y métodos de Character)
 *
 * Limpia y normaliza identificadores para desarrolladores:
 * 1. Reemplaza espacios por guiones bajos ('_').
 * 2. Convierte kebab-case a camelCase (elimina el guión '-' y pone la siguiente letra en mayúscula).
 * 3. Convierte dígitos en leetspeak a letras normales (4->a, 3->e, 0->o, 1->l, 7->t).
 * 4. Omite caracteres especiales que no sean letras.
 */
public class SqueakyClean {

    private static char replaceLeetDigit(char digit) {
        switch (digit) {
            case '4': return 'a';
            case '3': return 'e';
            case '0': return 'o';
            case '1': return 'l';
            case '7': return 't';
            default:  return digit;
        }
    }

    /**
     * Limpia un identificador según las 4 reglas especificadas.
     */
    public static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);

            // Regla 1: Espacios en blanco -> guión bajo
            if (Character.isWhitespace(ch)) {
                result.append('_');
                capitalizeNext = false;
            }
            // Regla 3: Dígitos leetspeak -> letras equivalentes
            else if (ch == '4' || ch == '3' || ch == '0' || ch == '1' || ch == '7') {
                char converted = replaceLeetDigit(ch);
                result.append(capitalizeNext ? Character.toUpperCase(converted) : converted);
                capitalizeNext = false;
            }
            // Regla 2: Guión '-' activa camelCase para la siguiente letra
            else if (ch == '-') {
                capitalizeNext = true;
            }
            // Regla 4: Letras se conservan (con mayúscula si venía después de un '-')
            else if (Character.isLetter(ch)) {
                result.append(capitalizeNext ? Character.toUpperCase(ch) : ch);
                capitalizeNext = false;
            }
            // Cualquier otro caracter no alfanumérico se omite
        }

        return result.toString();
    }
}
