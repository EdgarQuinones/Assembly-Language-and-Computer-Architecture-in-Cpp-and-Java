class E3 {
    
    public static void main(String[] args) {
        
        float x = 0.0f;
        while (x != 1.0f) // Results in infinite loop
            x += 0.1f;
        System.out.println("x: "+x);

    }

}

