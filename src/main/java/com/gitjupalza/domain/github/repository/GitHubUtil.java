package com.gitjupalza.domain.github.repository;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
@RequiredArgsConstructor
public class GitHubUtil {
    @Value("${github.token}")
    private String token;

    public Integer getStarCnt(String githubId) throws IOException, JSONException {
        String getUrl = "https://api.github.com/users/" + githubId + "/repos";
        int starCnt = 0;

        URL url = new URL(getUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("User-Agent", "request");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        try{
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }

            String jsonStr = sb.toString();

            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject explrObject = jsonArray.getJSONObject(i);
                    starCnt += Integer.parseInt(explrObject.get("stargazers_count").toString());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return starCnt;
    }

    public Integer getTotalCommitCnt(String githubId) throws IOException, JSONException {
        String getUrl = "https://api.github.com/users/" + githubId + "/repos";
        int commitCnt = 0;

        URL url = new URL(getUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);
        try{
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }

            String jsonStr = sb.toString();

            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject explrObject = jsonArray.getJSONObject(i);
                    commitCnt += getEachCommitCnt(explrObject.get("commits_url").toString());
                    //System.out.println("-------" + explrObject.get("commits_url").toString() + " " + getEachCommitCnt(githubId, explrObject.get("name").toString()));


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return commitCnt;
    }

    public Integer getEachCommitCnt(String currUrl) throws IOException, JSONException {
        String getUrl = currUrl.substring(0,currUrl.length()-6);
        int currCommitCnt = 0;

        URL url = new URL(getUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        try{
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }

            String jsonStr = sb.toString();

            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                currCommitCnt = jsonArray.length();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return currCommitCnt;
    }


}
