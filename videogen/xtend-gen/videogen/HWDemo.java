package videogen;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class HWDemo {
  private final Function1<String, Integer> x = ((Function1<String, Integer>) (String x) -> {
    return Integer.valueOf(x.length());
  });
}
