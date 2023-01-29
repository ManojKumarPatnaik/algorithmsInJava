package My_Learning.strings;

import java.util.HashSet;

public class UniqueEmailAddressLeetcode929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numUniqueEmails(String[] emails) {

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < emails.length; i++) {
			String local = emails[i].split("@")[0];
			String domain = emails[i].split("@")[1];

			if (local.contains("+")) {
				local = local.split("\\+")[0];
			}

			local = local.replaceAll("\\.", "");
			set.add(local + "@" + domain);
		}
		return set.size();
	}

}
