package com.nick.blog.features.java15;

public class TextBlock {
    public static void main(String... args){
        System.out.print("1:\n");
        textBlockHtml("nicksamoylov");

        System.out.print("\n2:\n");
        textBlockJson("World");

        System.out.print("\n3: ");
        textBlockLongLine("table1", "table2");

        System.out.print("\n4:\n");
        textBlockFormattedSpace1();

        System.out.print("\n5:\n");
        textBlockFormattedSpace2();
    }

    private static final String TEXT_BLOCK_HTML = """
        <html>
            <body>
               <h1>Hello, %s!</h1>
            </body>
        </html>
        """;
    private static void textBlockHtml(String name){
        String res = String.format(TEXT_BLOCK_HTML, name);
        System.out.print(res);
    }

    private static final String TEXT_BLOCK_JSON = """
        {
            "name" : "Nick Samoylov",
            "website" : "https://www.%s.com/"
        }
        """;
    private static void textBlockJson(String name){
        String res = String.format(TEXT_BLOCK_JSON, name);
        System.out.print(res);
    }

    private static final String TEXT_BLOCK_LONG_LINE = """
        select from %s t1 join %s t2 on t1.id=t2.parent_id \
        where t1.name = ? and t2.type = ? \
        and t2.timestamp < now() - '2 days'::interval \
        order by t2.id 
        """;
    private static void textBlockLongLine(String name1, String name2){
        String res = String.format(TEXT_BLOCK_LONG_LINE, name1, name2);
        System.out.print(res);
    }

    private static final String TEXT_BLOCK_FORMATTED_SPACE1 = """
              Jill \s 
              Bob  \s
              Andrew
              """;
    private static void textBlockFormattedSpace1(){
        System.out.print(TEXT_BLOCK_FORMATTED_SPACE1);
        String resultingString = "Jill  \nBob   \nAndrew\n";
        if(!TEXT_BLOCK_FORMATTED_SPACE1.equals(resultingString)){
            throw new RuntimeException("The resulting string is not equal the expected: " + resultingString);
        }
    }

    private static final String TEXT_BLOCK_FORMATTED_SPACE2 = """
              Jill \s 
              Bob  \s
              Andrew
            """;
    private static void textBlockFormattedSpace2(){
        System.out.print(TEXT_BLOCK_FORMATTED_SPACE2);
        String resultingString = "  Jill  \n  Bob   \n  Andrew\n";
        if(!TEXT_BLOCK_FORMATTED_SPACE2.equals(resultingString)){
            throw new RuntimeException("The resulting string is not equal the expected: " + resultingString);
        }
    }
}
