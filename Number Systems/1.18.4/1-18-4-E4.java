class E4 {
    
    public static void main(String[] args) {
        
        float x = 0.0f;
        while (Math.abs(x - 1.0f) > 0.00001f) // Must be close but not equal to 1 
            x += 0.1f;
        System.out.println("x: "+x);

    }

}

