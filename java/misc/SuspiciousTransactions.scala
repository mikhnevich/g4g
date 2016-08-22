package misc

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Palantir Technologies (Palo Alto, CA) in February 2016.
  *
  * Imagine you are working for a small bank, attempting to analyze fraudulent credit card transactions.
  * You are given a list of strings describing credit card transactions for a single day. All strings are
  * pipe‐delimited and will take the form of
  * "<person name>|<integer whole dollar amount>|<location>|<integer time in minutes since 00:00>".
  * The list is sorted in ascending order by time. Your job is to return a list of people's names whose accounts
  * reflect suspicious activity. A person's account reflects suspicious activity if you see of the following:
  * 1. A transaction spending more than $3000
  * 2. A transaction for which the next transaction for the same person differs in location, and is less than an hour later
  * The list you return should be ordered by when the first suspicious was detected.
  * For the second type of fraud, consider the "first suspicious activity" to be the earlier of the two transactions.
  * You have to complete the function getSuspiciousActivity to return the list of suspicious activities.
  * The list you return should contain the person names as they appeared in the input.
  * Please note that the first line of the input is the number of transactions in the array.
  *
  * Sample Input 1:
  * Shilpa|500|California|63
  * Tom|25|New York|615
  * Krasi|9000|California|1230
  * Tom|25|New York|1235
  * Tom|25|New York|1238
  * Shilpa|50|Michigan|1300
  * Matt|90000|Georgia|1305
  * Jay|100000|Virginia|1310
  * Krasi|49|Florida|1320
  * Krasi|83|California|1325
  * Shilpa|50|California|1350
  *
  * Sample Output 1:
  * Krasi Shilpa Matt Jay
  *
  * Explanation Krasi is first because she has exhibited amount fraud before any other account exhibited either
  * types of fraud (she then later also committed location fraud, but this doesn't matter). Shilpa is second,
  * having committed location fraud where the first transaction took place before either of Matt or Jay's amount
  * fraud. Matt and Jay both exhibited amount fraud, but Matt's fraud was recorded before Jay's. Tom is not on this
  * list because he did not commit either type of fraud.
  */
case class Transaction(name: String, amount: Int, location: String, time: Int)

object Transaction {
  def apply(v: String): Transaction = {
    val parts = v.split("\\|")
    Transaction(parts(0), parts(1).toInt, parts(2), parts(3).toInt)
  }
}

object SuspiciousTransactions {

  // this whole thing can be much simpler by splitting different users to different threads/processes
  // so each thread/process deals with its own user.
  def suspiciousUsers(ts: Seq[Transaction]): Seq[String] = {
    val last = mutable.Map[String, List[Transaction]]()
    val fraudSet = mutable.Set[String]()
    val fraud = ListBuffer[Transaction]()
    for (t <- ts if !fraudSet.contains(t.name)) {
      if (t.amount > 3000) {
        fraudSet.add(t.name)
        fraud += t
      } else {
        last.get(t.name) match {
          case Some(list) =>
            val newList = list.filter(x => t.time - x.time < 60)
            newList.find(_.location != t.location) match {
              case Some(f) => fraudSet.add(t.name)
                fraud += f
              case _ => last += (t.name -> (newList ++ List(t)))
            }
          case None => last.put(t.name, List(t))
        }
      }
    }
    fraud.sortBy(x => x.time).map(_.name)
  }

  def main(args: Array[String]) {
    val test = Array[String](
      "Shilpa|500|California|63",
      "Tom|25|New York|615",
      "Krasi|9000|California|1230",
      "Tom|25|New York|1235",
      "Tom|25|New York|1238",
      "Shilpa|50|Michigan|1300",
      "Matt|90000|Georgia|1305",
      "Jay|100000|Virginia|1310",
      "Krasi|49|Florida|1320",
      "Krasi|83|California|1325",
      "Shilpa|50|California|1350"
    )
    val ts = test.map(Transaction(_)).toSeq
    println(suspiciousUsers(ts))
  }
}
