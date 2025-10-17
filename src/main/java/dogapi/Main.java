package dogapi;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String breed = "hound";
        BreedFetcher breedFetcher = new CachingBreedFetcher(new BreedFetcherForLocalTesting());
        int result = getNumberOfSubBreeds(breed, breedFetcher);
        System.out.println(breed + " has " + result + " sub breeds");

        breed = "cat";
        result = getNumberOfSubBreeds(breed, breedFetcher);
        System.out.println(breed + " has " + result + " sub breeds");
    }

    /**
     * Return the number of sub breeds that the given dog breed has according to the
     * provided fetcher.
     * @param breed the name of the dog breed
     * @param breedFetcher the breedFetcher to use
     * @return the number of sub breeds. Zero should be returned if there are no sub breeds
     * returned by the fetcher
     */
    public static int getNumberOfSubBreeds(String breed, BreedFetcher breedFetcher) {
        // TODO Task 3 implement this code so that it is entirely consistent with its provided documentation.
        // return statement included so that the starter code can compile and run.
        int count = countSubBreeds(breed, breedFetcher);
        return count;
    }

    /**
     * Returns the total number of sub-breeds for the provided breed name.
     * Returns 0 if the breed does not exist or the fetcher fails.
     */
    public static int countSubBreeds(String breed, BreedFetcher fetcher) {
        try {
            // Ask the fetcher for a list of sub-breeds while counting them
            List<String> results = fetcher.getSubBreeds(breed);
            return results.size();
        } catch (BreedFetcher.BreedNotFoundException e) {
            // Return 0 when the breed isn't recognized or a network issues
            //test
            return 0;
        }
    }
}