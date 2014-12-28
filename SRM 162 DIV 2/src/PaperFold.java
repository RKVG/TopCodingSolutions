public class PaperFold {
	
	public int numFolds(int[] paper, int[] box) {

		int paperMax = Math.max(paper[0], paper[1]);
		int paperMin = Math.min(paper[0], paper[1]);
		int boxMax = Math.max(box[0], box[1]);
		int boxMin = Math.min(box[0], box[1]);

		int f1 = countFolds(paperMax, boxMax) + countFolds(paperMin, boxMin);
		int f2 = countFolds(paperMax, boxMin) + countFolds(paperMin, boxMax);

		int folds = Math.min(f1, f2);

		return (folds <= 8) ? folds : -1;
	}

	private static int countFolds(int a, int b)  {

		int folds = 0;

		while (a > b)  {
			folds++;
			b *= 2;
		}

		return folds;
	}
}
