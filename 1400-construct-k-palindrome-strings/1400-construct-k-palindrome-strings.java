class Solution
{

  public boolean canConstruct (String s, int k)
  {

    int[] hashtable = new int[26];

    if (s.length () < k)
        return false;

    for (char ch:s.toCharArray ())

        hashtable[ch - 'a']++;


    int distinct = 0;

    for (int i = 0; i < 26; i++)
      {

	if (hashtable[i] != 0 && hashtable[i] % 2 != 0)
	  {

	    distinct++;

	    if (distinct > k)
	      return false;

	  }
      }

    return true;

  }

}
