InputStream modelIn = new FileInputStream("en-chatbot-model.bin");
TokenizerModel model = new TokenizerModel(modelIn);
Tokenizer tokenizer = new TokenizerME(model);

String input = "Which player should I focus on?";
String[] tokens = tokenizer.tokenize(input);

for (String token : tokens) {
    System.out.println(token);
}

