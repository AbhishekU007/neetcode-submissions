class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key))
            return "";

        List<Pair<Integer, String>> list = keyStore.get(key);
        int left = 0, right = list.size() - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getKey() <= timestamp) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (answer == -1)
            return "";
        else
            return list.get(answer).getValue();
    }
}
