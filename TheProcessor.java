import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.lang.model.util.*;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes("*")
public class TheProcessor extends AbstractProcessor {

    private Messager messager;
    private int round = 0;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.round = 0;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        this.round += 1;
        messager.printMessage(Kind.NOTE, String.format("Round %d: [%s]",
            this.round,
            roundEnv.getRootElements().stream().map(Element::getSimpleName).collect(Collectors.joining(","))));
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
