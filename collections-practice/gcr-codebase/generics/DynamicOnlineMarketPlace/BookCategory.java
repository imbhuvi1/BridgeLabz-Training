package gcr_codebase.generics.DynamicOnlineMarketplace;

class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}