class E6 {
    
    public static void main(String[] args) {
        
        float sum = 0.0f;
        for (int i = 1; i <= 100; i++)
            sum += 1.0f / i;
        System.out.println("sum: "+sum);
        //sum: 5.187378
        // sum: 5.187377 when starting with 100



    }

}

