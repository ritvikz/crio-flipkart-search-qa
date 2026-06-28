package demo.wrappers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wrappers {

    WebDriver driver;

    public Wrappers(WebDriver driver){
        this.driver = driver;
    }

    public void openURL(String url){
        driver.get(url);
    }

    public void searchProduct(String item){
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.sendKeys(item);
        search.sendKeys(Keys.ENTER);
    }

    public void closeLoginPopup(){
        try{
            WebElement close = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            close.click();
        }catch(Exception e){}
    }

    public void sortByPopularity(){
        driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
    }

    public int countRatingLessThan4(){
        List<WebElement> ratings = driver.findElements(By.xpath("//div[contains(@class,'_3LWZlK')]"));
        int count = 0;

        for(WebElement r : ratings){
            try{
                double rating = Double.parseDouble(r.getText());
                if(rating <= 4.0){
                    count++;
                }
            }catch(Exception e){}
        }
        return count;
    }

    public List<String> getTitlesWithDiscountMoreThan17(){
        List<WebElement> cards = driver.findElements(By.xpath("//div[@data-id]"));
        List<String> result = new ArrayList<>();

        for(WebElement card : cards){
            try{
                String discountText = card.findElement(By.xpath(".//div[contains(text(),'% off')]")).getText();
                int discount = Integer.parseInt(discountText.replaceAll("[^0-9]",""));

                if(discount > 17){
                    String title = card.findElement(By.xpath(".//div[@class='_4rR01T' or @class='s1Q9rs']")).getText();
                    result.add(title);
                }
            }catch(Exception e){}
        }
        return result;
    }

    public void filter4Star(){
        driver.findElement(By.xpath("//div[text()='4★ & above']")).click();
    }

    public List<String> top5HighestReviews(){

        List<WebElement> cards = driver.findElements(By.xpath("//div[@data-id]"));
        List<Product> products = new ArrayList<>();

        for(WebElement card : cards){
            try{
                String title = card.findElement(By.xpath(".//a")).getText();
                String reviewsText = card.findElement(By.xpath(".//span[contains(text(),'Ratings')]")).getText();
                int reviews = Integer.parseInt(reviewsText.replaceAll("[^0-9]",""));
                String img = card.findElement(By.xpath(".//img")).getAttribute("src");

                products.add(new Product(title,reviews,img));
            }catch(Exception e){}
        }

        return products.stream()
                .sorted(Comparator.comparing(Product::getReviews).reversed())
                .limit(5)
                .map(p -> p.title + " | " + p.image)
                .collect(Collectors.toList());
    }

    class Product{
        String title;
        int reviews;
        String image;

        Product(String t,int r,String i){
            title=t;
            reviews=r;
            image=i;
        }

        int getReviews(){
            return reviews;
        }
    }
}