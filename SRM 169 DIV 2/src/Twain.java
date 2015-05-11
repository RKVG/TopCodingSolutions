public class Twain {

    public String getNewSpelling(int year, String phrase) {

		if (year >= 1)  {
            // If a word starts with x, replace it with a z
            phrase = phrase.replaceAll("\\bx","z");

            phrase = phrase.replaceAll("x","ks");
        }

        if (year >= 2)  {
            phrase = phrase.replaceAll("y", "i");
        }

        if (year >= 3)  {
            /*
            * If a 'c' is followed immediately by an 'e' or
            * an 'i', then replace the 'c' with an 's'.
            */
            phrase = phrase.replaceAll("c([ei])", "s$1");
        }

        if (year >= 4)  {

            /*
            * Remove repeating 'c's that end with a 'k'
            * with just a 'k'.
            */
            phrase = phrase.replaceAll("c+k", "k");
        }

        if (year >= 5)  {

            /*
            * Replace 'sch' at the beginning of a work with
            * 'sk'
            */
            phrase = phrase.replaceAll("\\bsch", "sk");

            phrase = phrase.replaceAll("chr", "kr");

            /*
            * Replace all 'c' s that are not followed immediately
            * by a 'h' with a 'k'
            */
            phrase = phrase.replaceAll("c(?!h)", "k");

        }

        if (year >= 6)  {

            /*
            * Replace all words that start with 'kn'
            * with just 'n'
            */
            phrase = phrase.replaceAll("\\bkn", "n");
        }

        if (year >= 7)  {

            /*
            * Replace all repeating consonants, with just the
            * single character.
            */
            phrase = phrase.replaceAll("([b-df-hj-np-tv-z])\\1+", "$1");
        }

        return phrase;
	}
}
