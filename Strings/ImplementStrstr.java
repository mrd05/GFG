class ImplementStrstr
{
    int strstr(String str, String target)
    {
        if(target.length()==0)
            return 0;
        if(str.length()==0)
            return -1;
        if(str.length() < target.length())
            return -1;
        for(int i=0;i<=str.length()-target.length();i++)
        {
            if(str.substring(i,i+target.length()).equals(target))
               return i;
        }
        return -1;
    }
}
