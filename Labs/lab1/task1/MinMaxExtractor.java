class MinMaxExtractor {

int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;

void process ( int [] numbers){
    for ( int i = 0; i< numbers.length ; i++){
        if ( numbers [i] < min){
            min = numbers [ i];
        }
        if ( numbers [i]> max){
            max = numbers [i];
        }
    }
}



}