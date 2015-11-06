package arraysanddp;

public class BinaryToGrey {
	/*
    The purpose of this function is to convert an unsigned
    binary number to reflected binary Gray code.

    The operator >> is shift right. The operator ^ is exclusive or.
*/
static int binaryToGray(int num)
{
    return (num >> 1) ^ num;
}

/*
    The purpose of this function is to convert a reflected binary
    Gray code number to a binary number.
*/
static int grayToBinary( int num)
{
int mask;
for (mask = num >> 1; mask != 0; mask = mask >> 1)
{
    num = num ^ mask;
}
return num;
}

static int nextGray(int num)
{
    return binaryToGray((grayToBinary(num) + 1));
}

static int prevGray (int num)
{
    return binaryToGray((grayToBinary(num) - 1));
}

public static void main(String args[])
{
	
	System.out.println(nextGray(1));


}
}
