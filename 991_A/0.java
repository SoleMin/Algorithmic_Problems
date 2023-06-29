import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;
import java.io.IOException;import java.io.PrintStream;import java.io.PrintWriter;
import java.security.AccessControlException;import java.util.Arrays;import java.util.Collection;
import java.util.Comparator;import java.util.List;import java.util.Map;import java.util.Objects;
import java.util.Scanner;import java.util.TreeMap;import java.util.function.Function;
import java.util.stream.Collectors;import java.util.stream.IntStream;import java.util.stream.LongStream;
import java.util.stream.Stream;public class _p000991A {static public void main(final String[] args) 
throws IOException{p000991A._main(args);}
static private class p000991A extends Solver{public p000991A(){nameIn="in/1000/p000991A.in";
singleTest=true;}@Override public void solve()throws IOException{int A=sc.nextInt();
int B=sc.nextInt();int C=sc.nextInt();int N=sc.nextInt();sc.nextLine();int res=-1;
if(C<=A && C<=B){res=N-(A+B-C);if(res<1){res=-1;}}pw.println(res);}static public 
void _main(String[]args)throws IOException{new p000991A().run();}}static private class 
Pair<K,V>{private K k;private V v;public Pair(final K t,final V u){this.k=t;this.v
=u;}public K getKey(){return k;}public V getValue(){return v;}}static private abstract class 
Solver{protected String nameIn=null;protected String nameOut=null;protected boolean 
singleTest=false;protected boolean preprocessDebug=false;protected boolean doNotPreprocess
=false;protected PrintStream debugPrintStream=null;protected Scanner sc=null;protected 
PrintWriter pw=null;final static String SPACE=" ";final static String SPACES="\\s+";
private void process()throws IOException{if(!singleTest){int t=lineToIntArray()[0];
while(t-->0){solve();}}else{solve();}}abstract protected void solve()throws IOException;
protected String[]lineToArray()throws IOException{return sc.nextLine().trim().split(SPACES);
}protected int[]lineToIntArray()throws IOException{return Arrays.stream(lineToArray()).mapToInt(Integer::valueOf).toArray();
}protected long[]lineToLongArray()throws IOException{return Arrays.stream(lineToArray()).mapToLong(Long::valueOf).toArray();
}protected void run()throws IOException{boolean done=false;try{if(nameIn!=null && 
new File(nameIn).exists()){try(FileInputStream fis=new FileInputStream(nameIn);PrintWriter 
pw0=select_output();){done=true;sc=new Scanner(fis);pw=pw0;process();}}}catch(IOException 
ex){}catch(AccessControlException ex){}if(!done){try(PrintWriter pw0=select_output();
){sc=new Scanner(System.in);pw=pw0;process();}}}private PrintWriter select_output()
throws FileNotFoundException{if(nameOut!=null){return new PrintWriter(nameOut);}
return new PrintWriter(System.out);}public static Map<Integer,List<Integer>>mapi(final 
int[]a){return IntStream.range(0,a.length).collect(()->new TreeMap<Integer,List<Integer>>(),
(res,i)->{if(!res.containsKey(a[i])){res.put(a[i],Stream.of(i).collect(Collectors.toList()));
}else{res.get(a[i]).add(i);}},Map::putAll);}public static Map<Long,List<Integer>>
mapi(final long[]a){return IntStream.range(0,a.length).collect(()->new TreeMap<Long,
List<Integer>>(),(res,i)->{if(!res.containsKey(a[i])){res.put(a[i],Stream.of(i).collect(Collectors.toList()));
}else{res.get(a[i]).add(i);}},Map::putAll);}public static<T>Map<T,List<Integer>>
mapi(final T[]a){return IntStream.range(0,a.length).collect(()->new TreeMap<T,List<Integer>>(),
(res,i)->{if(!res.containsKey(a[i])){res.put(a[i],Stream.of(i).collect(Collectors.toList()));
}else{res.get(a[i]).add(i);}},Map::putAll);}public static<T>Map<T,List<Integer>>
mapi(final T[]a,Comparator<T>cmp){return IntStream.range(0,a.length).collect(()->
new TreeMap<T,List<Integer>>(cmp),(res,i)->{if(!res.containsKey(a[i])){res.put(a[i],
Stream.of(i).collect(Collectors.toList()));}else{res.get(a[i]).add(i);}},Map::putAll
);}public static Map<Integer,List<Integer>>mapi(final IntStream a){int[]i=new int[]{0};
return a.collect(()->new TreeMap<Integer,List<Integer>>(),(res,v)->{if(!res.containsKey(v))
{res.put(v,Stream.of(i[0]).collect(Collectors.toList()));}else{res.get(v).add(i[0]);
}i[0]++;},Map::putAll);}public static Map<Long,List<Integer>>mapi(final LongStream 
a){int[]i=new int[]{0};return a.collect(()->new TreeMap<Long,List<Integer>>(),(res,
v)->{if(!res.containsKey(v)){res.put(v,Stream.of(i[0]).collect(Collectors.toList()));
}else{res.get(v).add(i[0]);}i[0]++;},Map::putAll);}public static<T>Map<T,List<Integer>>
mapi(final Stream<T>a,Comparator<T>cmp){int[]i=new int[]{0};return a.collect(()->
new TreeMap<T,List<Integer>>(cmp),(res,v)->{if(!res.containsKey(v)){res.put(v,Stream.of(i[0]).collect(Collectors.toList()));
}else{res.get(v).add(i[0]);}},Map::putAll);}public static<T>Map<T,List<Integer>>
mapi(final Stream<T>a){int[]i=new int[]{0};return a.collect(()->new TreeMap<T,List<Integer>>(),
(res,v)->{if(!res.containsKey(v)){res.put(v,Stream.of(i[0]).collect(Collectors.toList()));
}else{res.get(v).add(i[0]);}},Map::putAll);}public static List<int[]>listi(final 
int[]a){return IntStream.range(0,a.length).mapToObj(i->new int[]{a[i],i}).collect(Collectors.toList());
}public static List<long[]>listi(final long[]a){return IntStream.range(0,a.length).mapToObj(i
->new long[]{a[i],i}).collect(Collectors.toList());}public static<T>List<Pair<T,
Integer>>listi(final T[]a){return IntStream.range(0,a.length).mapToObj(i->new Pair<T,
Integer>(a[i],i)).collect(Collectors.toList());}public static List<int[]>listi(final 
IntStream a){int[]i=new int[]{0};return a.mapToObj(v->new int[]{v,i[0]++}).collect(Collectors.toList());
}public static List<long[]>listi(final LongStream a){int[]i=new int[]{0};return 
a.mapToObj(v->new long[]{v,i[0]++}).collect(Collectors.toList());}public static<T>
List<Pair<T,Integer>>listi(final Stream<T>a){int[]i=new int[]{0};return a.map(v->
new Pair<T,Integer>(v,i[0]++)).collect(Collectors.toList());}public static String 
join(final int[]a){return Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(SPACE));
}public static String join(final long[]a){return Arrays.stream(a).mapToObj(Long::toString).collect(Collectors.joining(SPACE));
}public static<T>String join(final T[]a){return Arrays.stream(a).map(v->Objects.toString(v)).collect(Collectors.joining(SPACE));
}public static<T>String join(final T[]a,final Function<T,String>toString){return 
Arrays.stream(a).map(v->toString.apply(v)).collect(Collectors.joining(SPACE));}public 
static<T>String join(final Collection<T>a){return a.stream().map(v->Objects.toString(v)).collect(Collectors.joining(SPACE));
}public static<T>String join(final Collection<T>a,final Function<T,String>toString)
{return a.stream().map(v->toString.apply(v)).collect(Collectors.joining(SPACE));
}public static<T>String join(final Stream<T>a){return a.map(v->Objects.toString(v)).collect(Collectors.joining(SPACE));
}public static<T>String join(final Stream<T>a,final Function<T,String>toString){
return a.map(v->toString.apply(v)).collect(Collectors.joining(SPACE));}public static
<T>String join(final IntStream a){return a.mapToObj(Integer::toString).collect(Collectors.joining(SPACE));
}public static<T>String join(final LongStream a){return a.mapToObj(Long::toString).collect(Collectors.joining(SPACE));
}public static List<Integer>list(final int[]a){return Arrays.stream(a).mapToObj(Integer::valueOf).collect(Collectors.toList());
}public static List<Integer>list(final IntStream a){return a.mapToObj(Integer::valueOf).collect(Collectors.toList());
}public static List<Long>list(final long[]a){return Arrays.stream(a).mapToObj(Long::valueOf).collect(Collectors.toList());
}public static List<Long>list(final LongStream a){return a.mapToObj(Long::valueOf).collect(Collectors.toList());
}public static<T>List<T>list(final Stream<T>a){return a.collect(Collectors.toList());
}public static<T>List<T>list(final T[]a){return Arrays.stream(a).collect(Collectors.toList());
}}}
