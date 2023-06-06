package pl.comarch.szkolenia.book.store.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@NoArgsConstructor
@Getter
@Setter
public class SessionData {
    private boolean logged = false;
}
