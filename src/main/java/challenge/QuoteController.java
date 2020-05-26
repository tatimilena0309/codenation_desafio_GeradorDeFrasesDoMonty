package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

    @Autowired
    private QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Quote> getQuote() {
        Quote quote = service.getQuote();
        if (quote == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(quote);
        }
    }

    @GetMapping("/{actor}")
    public ResponseEntity<Quote> getQuoteByActor(@PathVariable("actor") String actor) {
        Quote quote = service.getQuoteByActor(actor);
        if (quote == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(quote);
        }
    }
}
