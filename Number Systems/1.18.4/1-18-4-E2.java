class E2 {
    
    public static void main(String[] args) {
        
        float sum = 0.0f, z = 1.0f/1024.0f;
        for (int i = 1; i <= 1024; i++) 
            sum = sum + z;
        System.out.println("sum = "+sum); // The reason E2 works is because 1.0/1024.0 is a value that can be **exactly represented as a floating point number**

    }

}

