package offer3;
/*牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？*/
public class ReverseSentenceT {
    public static String ReverseSentence(String str) {
        String result="";
        String[] strings=str.split(" ");
        if (strings.length==1){
            return strings[0];
        }else if (strings.length<1){
            return str;
        }
        result=strings[strings.length-1];
        for (int i=strings.length-2;i>=0;i--){
            result=result+" "+strings[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }
}
