
public class Transforms implements ImageInterface{
	PictureLibrary picture = null;
	int imgWidth = 0;
	int imgHeight = 0;
	int imgData[][];
	
	public Transforms() {
		picture = new PictureLibrary();
	}

	@Override
	public void readImage(String inFile) {
		// TODO Auto-generated method stub
		try {
			picture.readPGM(inFile);
			imgHeight = picture.getHeight();
			imgWidth = picture.getWidth();
			imgData = picture.getData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void writeImage(String outFile) {
		// TODO Auto-generated method stub
		try{
			picture.setData(imageData());
			picture.writePGM(outFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int[][] imageData() {
		// TODO Auto-generated method stub
		return imgData;
	}

	@Override
	public void decode() {
		// TODO Auto-generated method stub
		for (int r = 0; r < imgData.length; r++) {
			for(int c = 0; c < imgData[r].length; c++) {
				imgData[r][c] &= 0b01110011;
				imgData[r][c] <<= 2;
				imgData[r][c] |= 0b00000011;
			}
		}
		
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		int t1;
		int t2;
		int t3;
		for (int i = 0; i < imgData.length; i++) {
			for (int j = 0; j < imgData[i].length; j++) {
				t1 = imgData[i][j] & 0b11100000;
				t2 = imgData[i][j] & 0b00000111;
				t3 = imgData[i][j] & 0b00011000;
				imgData[i][j] = (t1>>5) | (t2<<2) | t3;
			}
		}
		
	}

	@Override
	public void mirror() {
		// TODO Auto-generated method stub
		int [] temp;
		int top = 0;
		int bottom = imgData.length-1;
		while(bottom >= top) {
			temp = imgData[top];
			imgData[top++] = imgData[bottom];
			imgData[bottom--] = temp;
		}
		
	}

	@Override
	public void exchange() {
		// TODO Auto-generated method stub
		if (imgWidth >= 425 && imgHeight >= 280) {
			int topRow = 80;
			int col1 = 50;
			int col2 = 275;
			int temp;
			for (int r = 0; r < 150; r++) {
				for (int c = 0; c < 200; c++) {
					temp = imgData[topRow + r][col1 + c];
					imgData[topRow + r][col1 + c] = imgData[topRow + r][col2 + c];
					imgData[topRow + r][col2 + c] = temp;
				}
			}
		}
	}

}
